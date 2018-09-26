package com.bitmovin.api;

import com.bitmovin.api.analytics.query.AnalyticsQuery;
import com.bitmovin.api.encoding.analysis.AnalysisDetails;
import com.bitmovin.api.encoding.status.Message;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.AnswerStatus;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RequestMethod;
import com.bitmovin.api.http.RestException;
import com.bitmovin.api.http.UnirestRestClient;
import com.bitmovin.api.http.exceptions.RestClientException;
import com.bitmovin.api.resource.AbstractResourcePatch;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
    private static boolean debug = false;
    private static boolean retry = false;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JSONObject convertToJsonObject(Object object) throws JsonProcessingException
    {
        return new JSONObject(objectMapper.writeValueAsString(object));
    }

    private static <T> T convertFromJsonObjectToPojo(JSONObject object, TypeReference<T> typeReference) throws IOException
    {
        return objectMapper.readValue(object.toString(), typeReference);
    }

    public static <T> T convertFromJsonObjectToPojo(JSONObject object, Class<T> clazz) throws IOException
    {
        return objectMapper.readValue(object.toString(), clazz);
    }

    private static ResponseEnvelope tryToConvertRawBodyToResponseEnvelope(String rawBody)
    {
        if (StringUtils.isBlank(rawBody))
        {
            return null;
        }

        try
        {
            return objectMapper.readValue(rawBody, ResponseEnvelope.class);
        }
        catch (IOException e)
        {
            return null;
        }
    }

    private static <T> T request(String resource, Map<String, String> headers, Object content, Class<T> classOfT, RequestMethod method) throws BitmovinApiException
    {
        String url = API_ENDPOINT_WITH_PROTOCOL + "/" + resource;
        UnirestRestClient unirestClient = new UnirestRestClient(objectMapper, isDebug(), isRetry());
        try
        {
            switch (method)
            {
                case POST:
                    return unirestClient.postAsObject(url, headers, content, classOfT);
                case GET:
                    return unirestClient.getAsObject(url, headers, classOfT);
                case DELETE:
                    return unirestClient.deleteAsObject(url, headers, classOfT);
                case PATCH:
                    return unirestClient.patchAsObject(url, headers, content, classOfT);
            }
            throw new BitmovinApiException("Request method: " + method.name() + " is not supported");
        }
        catch (RestClientException e)
        {
            ResponseEnvelope responseEnvelope = tryToConvertRawBodyToResponseEnvelope(e.getRawBody());
            if (responseEnvelope != null)
            {
                throw new BitmovinApiException(e.getStatusCode(), responseEnvelope);
            }
            throw new BitmovinApiException(
                    String.format(
                            "Got error response from request '%s' to url '%s'",
                            method.toString(),
                            url
                    )
            );
        }
    }

    public static void postAndForget(String resource, Map<String, String> headers, Object content) throws BitmovinApiException, RestException, IOException, UnirestException, URISyntaxException
    {
        request(resource, headers, content, RequestMethod.POST);
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
        request(resource, headers, content, method, API_ENDPOINT_WITH_PROTOCOL);
    }

    private static void request(String resource, Map<String, String> headers, Object content, RequestMethod method, String apiEndpoint) throws URISyntaxException, BitmovinApiException, IOException, RestException, UnirestException
    {
        String url = apiEndpoint + "/" + resource;
        UnirestRestClient restClient = new UnirestRestClient(objectMapper, isDebug(), isRetry());

        try
        {
            switch (method)
            {
                case POST:
                    restClient.postIgnoreResponse(url, headers, content);
                    return;
                case GET:
                    restClient.getIgnoreResponse(url, headers);
                    return;
                case DELETE:
                    restClient.deleteIgnoreResponse(url, headers);
                    return;
                default:
                    throw new BitmovinApiException("Request method: " + method.name() + " is not supported");
            }
        }
        catch (RestClientException e)
        {
            throw new BitmovinApiException(
                    String.format(
                            "Got error response from request '%s' to url '%s'",
                            method.toString(),
                            url
                    )
            );
        }

    }

    public static <T> T get(String url, Map<String, String> headers, Class<T> expectedClass) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        ResponseEnvelope responseEnvelope = request(url, headers, null, ResponseEnvelope.class, RequestMethod.GET);
        return getDetailsFromResponse(responseEnvelope, expectedClass);
    }

    public static <T> T get(String url, Map<String, String> headers, TypeReference<T> expectedClass) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
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

    public static JSONArray postAnalyticsQuery(String resource, Map<String, String> additionalHeaders, AnalyticsQuery query) throws BitmovinApiException, URISyntaxException, UnirestException, JsonProcessingException
    {
        ResponseEnvelope responseEnvelope = request(resource, additionalHeaders, query, ResponseEnvelope.class, RequestMethod.POST);
        JSONObject responseObject = convertToJsonObject(responseEnvelope.getData());
        return responseObject.getJSONObject("result").getJSONArray("rows");
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
        return getItems(url, headers, clazz, limit, offset, null);
    }

    private static <T> List<T> getItems(String url, Map<String, String> headers, Class<T> clazz, int limit, int offset, ITypeCallback callback) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        List<T> items = new ArrayList<>();

        ResponseEnvelope responseEnvelope = request(String.format("%s?offset=%d&limit=%d", url, offset, limit), headers, null, ResponseEnvelope.class, RequestMethod.GET);
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        JSONArray jsonItems = responseObject.getJSONObject("data").getJSONObject("result").getJSONArray("items");

        for (int i = 0; i < jsonItems.length(); i++)
        {
            JSONObject idObject = jsonItems.getJSONObject(i);
            Class<T> tempClass = clazz;
            if (callback != null)
            {
                tempClass = callback.getClazz(idObject);
            }
            items.add(convertFromJsonObjectToPojo(idObject, tempClass));
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

    public static <T extends AbstractApiResponse> List<T> postAndGetResults(Map<String, String> headers, String url, T body, Class<T> classOfT) throws BitmovinApiException, UnirestException, URISyntaxException, IOException
    {
        List<T> items = new ArrayList<>();

        ResponseEnvelope responseEnvelope = request(url, headers, body, ResponseEnvelope.class, RequestMethod.POST);
        JSONObject responseObject = convertToJsonObject(responseEnvelope);
        JSONArray jsonItems = responseObject.getJSONObject("data").getJSONArray("result");

        for (int i = 0; i < jsonItems.length(); i++)
        {
            JSONObject idObject = jsonItems.getJSONObject(i);
            items.add(convertFromJsonObjectToPojo(idObject, classOfT));
        }

        return items;
    }


    public static <T> List<T> getAllItemsIterative(String url, Map<String, String> headers, Class<T> clazz) throws IOException, BitmovinApiException, UnirestException, URISyntaxException
    {
        return getAllItemsIterative(url, headers, clazz, null);
    }

    public static <T> List<T> getAllItemsIterative(String url, Map<String, String> headers, Class<T> clazz, ITypeCallback callback) throws IOException, BitmovinApiException, UnirestException, URISyntaxException
    {
        Long totalCount = getTotalCount(url, headers);
        List<T> items = new ArrayList<>();

        int limit = 100;
        int offset = 0;

        List<T> pageItems;
        while (items.size() <= totalCount)
        {
            pageItems = getItems(url, headers, clazz, limit, offset, callback);
            if (pageItems.size() > 0)
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

    private static <T> T getDetailsFromResponse(ResponseEnvelope responseEnvelope, TypeReference<T> classOfT) throws IOException
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

        List<Message> messages = readMessagesFromResponse(responseObject);
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

        List<Message> messages = readMessagesFromResponse(responseObject);
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

        List<Message> messages = readMessagesFromResponse(responseObject);
        item.setMessages(messages);
        return item;
    }

    private static List<Message> readMessagesFromResponse(JSONObject responseObject)
    {
        List<Message> messages = new ArrayList<>();

        try
        {
            JSONArray messagesArray = responseObject.getJSONObject("data").getJSONArray("messages");
            for (int i = 0; i < messagesArray.length(); i++)
            {
                JSONObject idObject = messagesArray.getJSONObject(i);
                messages.add(convertFromJsonObjectToPojo(idObject, Message.class));
            }
        }
        catch (JSONException e)
        {
            // Ignore exception on missing messages field.
            return messages;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return messages;
    }

    public static boolean isRetry()
    {
        return retry;
    }

    public static void setRetry(boolean retry)
    {
        RestClient.retry = retry;
    }

    public static boolean isDebug()
    {
        return debug;
    }

    public static void setDebug(boolean debug)
    {
        RestClient.debug = debug;
    }

}
