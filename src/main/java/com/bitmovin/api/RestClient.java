package com.bitmovin.api;

import com.bitmovin.api.encoding.analysis.AnalysisDetails;
import com.bitmovin.api.encoding.status.Message;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.AnswerStatus;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.AbstractResourcePatch;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.http.JsonRestClient;
import com.bitmovin.api.http.RequestMethod;
import com.bitmovin.api.http.RestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bitmovin.api.constants.ApiUrls.API_ENDPOINT_WITH_PROTOCOL;

/**
 * Created by rkersche on 9/2/16.
 **/
public class RestClient
{

    public static JSONObject convertToJsonObject(Object object) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        return new JSONObject(mapper.writeValueAsString(object));
    }

    public static <T> T convertFromJsonObjectToPojo(JSONObject object, TypeReference<T> typeReference) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(object.toString(), typeReference);
    }

    public static <T> T convertFromJsonObjectToPojo(JSONObject object, Class<T> clazz) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(object.toString(), clazz);
    }

    private static <T> T request(String resource, Map<String, String> headers, Object content, Class<T> classOfT, RequestMethod method) throws UnirestException, URISyntaxException, BitmovinApiException
    {
        String url = API_ENDPOINT_WITH_PROTOCOL + "/" + resource;
        JsonRestClient jRest = new JsonRestClient();
        switch (method)
        {
            case POST:
                return jRest.post(new URI(url), headers, content, classOfT);
            case GET:
                return jRest.get(new URI(url), headers, classOfT);
            case DELETE:
                return jRest.delete(new URI(url), headers, classOfT);
            case PATCH:
                return jRest.patch(new URI(url), headers, content, classOfT);
        }
        throw new BitmovinApiException("Request method: " + method.name() + " is not supported");
    }

    private static <T> T post(String resource, Map<String, String> headers, Object content, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException
    {
        return request(resource, headers, content, classOfT, RequestMethod.POST);
    }

    private static <T> T patch(String resource, Map<String, String> headers, Object content, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException
    {
        return request(resource, headers, content, classOfT, RequestMethod.PATCH);
    }

    public static void delete(String resource, Map<String, String> additionalHeaders, Object content) throws BitmovinApiException, RestException, IOException, URISyntaxException, UnirestException
    {
        request(resource, additionalHeaders, content, RequestMethod.DELETE);
    }

    public static void delete(String resource, Map<String, String> additionalHeaders) throws BitmovinApiException, RestException, IOException, URISyntaxException, UnirestException
    {
        request(resource, additionalHeaders, null, RequestMethod.DELETE);
    }

    private static void request(String resource, Map<String, String> headers, Object content, RequestMethod method) throws URISyntaxException, BitmovinApiException, IOException, RestException, UnirestException
    {
        String url = API_ENDPOINT_WITH_PROTOCOL + "/" + resource;
        JsonRestClient jRest = new JsonRestClient();

        switch (method)
        {
            case POST:
                jRest.post(new URI(url), headers, content);
                return;
            case GET:
                jRest.get(new URI(url), headers);
                return;
            case DELETE:
                jRest.delete(new URI(url), headers, content);
                return;
        }

        throw new BitmovinApiException("Request method: " + method.name() + " is not supported");
    }

    public static <T> T get(String url, Map<String, String> headers, Class<T> expectedClass) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = request(url, headers, null, ResponseEnvelope.class, RequestMethod.GET);
        return getDetailsFromResponse(responseEnvelope, expectedClass);
    }

    public static <T> T getRaw(String url, Map<String, String> headers, Class<T> expectedClass) throws BitmovinApiException, UnirestException, URISyntaxException
    {
        return request(url, headers, null, expectedClass, RequestMethod.GET);
    }

    public static String getIdFromResponse(ResponseEnvelope responseEnvelope) throws JsonProcessingException
    {
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        return responseObject.getJSONObject("data").getJSONObject("result").getString("id");
    }

    public static Task getAnalysisTaskFromResponse(ResponseEnvelope responseEnvelope) throws IOException
    {
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        return convertFromJsonObjectToPojo(responseObject.getJSONObject("data").getJSONObject("result"), Task.class);
    }

    public static AnalysisDetails getAnalysisDetailsFromResponse(ResponseEnvelope responseEnvelope) throws IOException
    {
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        return convertFromJsonObjectToPojo(responseObject.getJSONObject("data").getJSONObject("result"), AnalysisDetails.class);
    }


    public static <T> T postDetail(String resource, Map<String, String> additionalHeaders, Object content, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = request(resource, additionalHeaders, content, ResponseEnvelope.class, RequestMethod.POST);
        return getDetailsFromResponse(responseEnvelope, classOfT);
    }

    public static <T> T postRaw(String resource, Map<String, String> additionalHeaders, Object content, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException
    {
        return request(resource, additionalHeaders, content, classOfT, RequestMethod.POST);
    }

    public static List<String> getListOfIds(String url, Map<String, String> headers) throws BitmovinApiException, UnirestException, URISyntaxException, JsonProcessingException
    {
        int offset = 0;
        int totalCount;
        List<String> idList = new ArrayList<>();
        do
        {
            ResponseEnvelope responseEnvelope = request(String.format("%s?offset=%d&limit=100", url, offset), headers, null, ResponseEnvelope.class, RequestMethod.GET);
            JSONObject responseObject = convertToJsonObject(responseEnvelope);
            JSONArray items = responseObject.getJSONObject("data").getJSONObject("result").getJSONArray("items");
            totalCount = responseObject.getJSONObject("data").getJSONObject("result").getInt("totalCount");
            for (int i = 0; i < items.length(); i++)
            {
                JSONObject idObject = items.getJSONObject(i);
                idList.add(idObject.getString("id"));
            }
            offset += 100;
        } while (offset < totalCount);
        return idList;
    }

    public static <T> List<T> getItems(String url, Map<String, String> headers, Class<T> clazz, int limit, int offset) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        List<T> items = new ArrayList<>();

        ResponseEnvelope responseEnvelope = request(String.format("%s?offset=%d&limit=%d", url, offset, limit), headers, null, ResponseEnvelope.class, RequestMethod.GET);
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        JSONArray jsonItems = responseObject.getJSONObject("data").getJSONObject("result").getJSONArray("items");

        for (int i = 0; i < jsonItems.length(); i++)
        {
            JSONObject idObject = jsonItems.getJSONObject(i);
            items.add(convertFromJsonObjectToPojo(idObject, clazz));
        }

        return items;
    }

    public static Long getTotalCount(String url, Map<String, String> headers) throws BitmovinApiException, UnirestException, URISyntaxException, JsonProcessingException
    {
        ResponseEnvelope responseEnvelope = request(url, headers, null, ResponseEnvelope.class, RequestMethod.GET);
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        return responseObject.getJSONObject("data").getJSONObject("result").getLong("totalCount");
    }

    public static List<Map<String, Object>> getItemsAsHashMap(String url, Map<String, String> headers) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        List<Map<String, Object>> items = new ArrayList<>();

        ResponseEnvelope responseEnvelope = request(url, headers, null, ResponseEnvelope.class, RequestMethod.GET);
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        JSONArray jsonItems = responseObject.getJSONObject("data").getJSONObject("result").getJSONArray("items");

        for (int i = 0; i < jsonItems.length(); i++)
        {
            JSONObject idObject = jsonItems.getJSONObject(i);
            items.add(convertFromJsonObjectToPojo(idObject, new TypeReference<Map<String, Object>>()
            {
            }));
        }

        return items;
    }

    public static <T> List<T> getItems(String url, Map<String, String> headers, Class<T> clazz) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        List<T> items = new ArrayList<>();

        ResponseEnvelope responseEnvelope = request(url, headers, null, ResponseEnvelope.class, RequestMethod.GET);
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        JSONArray jsonItems = responseObject.getJSONObject("data").getJSONObject("result").getJSONArray("items");

        for (int i = 0; i < jsonItems.length(); i++)
        {
            JSONObject idObject = jsonItems.getJSONObject(i);
            items.add(convertFromJsonObjectToPojo(idObject, clazz));
        }

        return items;
    }

    public static <T> List<T> getAllItemsIterative(String url, Map<String, String> headers, Class<T> clazz) throws IOException, BitmovinApiException, UnirestException, URISyntaxException
    {
        Long totalCount = getTotalCount(url, headers);
        List<T> items = new ArrayList<>();

        int limit = 100;
        int offset = 0;

        List<T> pageItems;
        while(items.size() <= totalCount)
        {
            pageItems = getItems(url, headers, clazz, limit, offset);
            if(pageItems.size() > 0)
            {
                items.addAll(pageItems);
                offset += pageItems.size();
            }
            else
            {
                return items;
            }
        }

        return items;
    }

    private static <T> T getDetailsFromResponse(ResponseEnvelope responseEnvelope, Class<T> classOfT) throws IOException
    {
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        JSONObject resultObject = responseObject.getJSONObject("data").getJSONObject("result");
        return convertFromJsonObjectToPojo(resultObject, classOfT);
    }


    public static <T> T getDetailsFromResponse(String url, Map<String, String> headers, Class<T> expectedClass) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = getRaw(url, headers, ResponseEnvelope.class);
        return RestClient.getDetailsFromResponse(responseEnvelope, expectedClass);
    }

    public static <T extends AbstractApiResponse> T post(Map<String, String> headers, String url, T body, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = post(url, headers, body, ResponseEnvelope.class);

        T item = getDetailsFromResponse(responseEnvelope, classOfT);
        item.setResponseEnvelope(responseEnvelope);

        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        item.setStatus(AnswerStatus.valueOf(responseObject.getString("status")));

        //read Messages
        JSONArray messagesArray = responseObject.getJSONObject("data").getJSONArray("messages");
        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < messagesArray.length(); i++)
        {
            JSONObject idObject = messagesArray.getJSONObject(i);
            messages.add(convertFromJsonObjectToPojo(idObject, Message.class));
        }
        item.setMessages(messages);
        return item;
    }

    public static <T extends AbstractApiResponse> T post(Map<String, String> headers, String url, T body) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = post(url, headers, body, ResponseEnvelope.class);

        body.setResponseEnvelope(responseEnvelope);
        body.setId(getIdFromResponse(responseEnvelope));

        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        body.setStatus(AnswerStatus.valueOf(responseObject.getString("status")));

        JSONArray messagesArray = responseObject.getJSONObject("data").getJSONArray("messages");
        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < messagesArray.length(); i++)
        {
            JSONObject idObject = messagesArray.getJSONObject(i);
            messages.add(convertFromJsonObjectToPojo(idObject, Message.class));
        }
        body.setMessages(messages);
        return body;
    }

    public static <T extends AbstractApiResponse> T patch(Map<String, String> headers, String url, AbstractResourcePatch patch, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = patch(url, headers, patch, ResponseEnvelope.class);

        T item = getDetailsFromResponse(responseEnvelope, classOfT);
        item.setResponseEnvelope(responseEnvelope);

        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        item.setStatus(AnswerStatus.valueOf(responseObject.getString("status")));

        JSONArray messagesArray = responseObject.getJSONObject("data").getJSONArray("messages");
        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < messagesArray.length(); i++)
        {
            JSONObject idObject = messagesArray.getJSONObject(i);
            messages.add(convertFromJsonObjectToPojo(idObject, Message.class));
        }
        item.setMessages(messages);
        return item;
    }


}
