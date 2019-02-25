package com.bitmovin.api.common;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

public class BitmovinDecoder implements Decoder
{
    private final ObjectMapper mapper;

    public BitmovinDecoder(ObjectMapper mapper)
    {
        this.mapper = mapper;
    }

    private boolean checkIsSuccessResponse(JsonNode jsonNode) {
        return jsonNode.get("status") != null && jsonNode.get("status").asText().equals("SUCCESS");
    }

    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException
    {
        Reader reader = response.body().asReader();
        if (!reader.markSupported())
        {
            reader = new BufferedReader(reader, 1);
        }
        try
        {
            reader.mark(1);
            if (reader.read() == -1)
            {
                return null;
            }
            reader.reset();

            JavaType javaType = this.mapper.constructType(type);
            JsonNode jsonNode = this.mapper.readValue(reader, JsonNode.class);

            if (jsonNode == null) {
                throw new DecodeException("Response does not contain valid json data");
            }

            if (!this.checkIsSuccessResponse(jsonNode)) {
                throw new DecodeException("Got non success response");
            }

            if (jsonNode.get("data") == null) {
                throw new DecodeException("Could not deserialize data object from response");
            }

            JsonNode resultDataJson = jsonNode.get("data").get("result");
            if (resultDataJson == null) {
                throw new DecodeException("Could not deserialize result object from response");
            }

            if (javaType.isCollectionLikeType()) {
                JsonNode items = resultDataJson.get("items");
                if (items == null || !items.isArray()) {
                    throw new DecodeException("Could not deserialize array data from response");
                }
                return mapper.convertValue(items, javaType);
            }

            return mapper.convertValue(resultDataJson, javaType);
        }
        catch (RuntimeJsonMappingException e)
        {
            if (e.getCause() != null && e.getCause() instanceof IOException)
            {
                throw (IOException) e.getCause();
            }
            throw e;
        }
    }
}
