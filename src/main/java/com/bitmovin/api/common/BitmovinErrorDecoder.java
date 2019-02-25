package com.bitmovin.api.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BitmovinErrorDecoder implements ErrorDecoder
{
    private final ObjectMapper mapper;

    public BitmovinErrorDecoder(ObjectMapper mapper)
    {
        this.mapper = mapper;
    }

    public Exception decode(String methodKey, Response response)
    {
        try
        {
            Reader reader = response.body().asReader();
            if (!reader.markSupported())
            {
                reader = new BufferedReader(reader, 1);
            }
            reader.mark(1);
            if (reader.read() == -1)
            {
                return FeignException.errorStatus(methodKey, response);
            }
            reader.reset();

            JsonNode jsonNode = this.mapper.readValue(reader, JsonNode.class);

            if (jsonNode == null) {
                return new BitmovinException("Response does not contain valid json data", response.status());
            }

            String rawJsonResponse = jsonNode.toString();

            JsonNode errorData = jsonNode.get("data");
            if (errorData == null) {
                return new BitmovinException("Could not deserialize error data", response.status());
            }

            JsonNode errorCodeNode = errorData.get("code");
            JsonNode errorMessageNode = errorData.get("message");
            JsonNode developerMessageNode = errorData.get("developerMessage");

            int errorCode = errorCodeNode != null ? errorCodeNode.asInt() : 0;
            String errorMessage = errorMessageNode != null ? errorMessageNode.asText() : "";
            String developerMessage = developerMessageNode != null ? developerMessageNode.asText() : "";

            ArrayNode detailsNode = errorData.get("details") != null && errorData.get("details").isArray() ? (ArrayNode) errorData.get("details") : this.mapper.createArrayNode();
            List<BitmovinErrorDetails> errorDetails = this.mapper.convertValue(detailsNode, new TypeReference<List<BitmovinErrorDetails>>(){});

            return new BitmovinException(errorMessage, response.status(), errorCode, developerMessage, errorDetails, rawJsonResponse);

        }
        catch (IOException e)
        {
            return e;
        }
    }
}
