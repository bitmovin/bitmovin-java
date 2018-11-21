package com.bitmovin.api;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.container.AnalyticsContainer;
import com.bitmovin.api.container.ConfigurationContainer;
import com.bitmovin.api.container.FilterContainer;
import com.bitmovin.api.container.InfrastructureContainer;
import com.bitmovin.api.container.InputContainer;
import com.bitmovin.api.container.ManifestContainer;
import com.bitmovin.api.container.NotificationContainer;
import com.bitmovin.api.container.OutputContainer;
import com.bitmovin.api.container.StatisticsContainer;
import com.bitmovin.api.container.StorageContainer;
import com.bitmovin.api.container.TransferContainer;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.bitmovin.api.resource.EncodingResource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by
 * David Moser [david.moser@bitmovin.com]
 * on 7/13/16
 */
public class BitmovinApi
{
    private static String X_API_CLIENT_CONFIGURATION_KEY = "x-api-client";
    private static String X_API_CLIENT_VERSION_CONFIGURATION_KEY = "x-api-client-version";

    private static String DEFAULT_X_API_CLIENT = "bitmovin-java-api";
    private static String DEFAULT_X_API_CLIENT_VERSION = "1.47.0";

    private Properties properties;

    private String apiKey;
    private String apiUrl;
    private String tenantID;
    private HashMap<String, String> defaultHeaders = new HashMap<>();

    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
            = new com.fasterxml.jackson.databind.ObjectMapper();

    public ConfigurationContainer configuration;
    public AnalyticsContainer analytics;
    public EncodingResource encoding;
    public FilterContainer filter;
    public InputContainer input;
    public ManifestContainer manifest;
    public OutputContainer output;
    public StorageContainer storage;
    public TransferContainer transfer;
    public NotificationContainer notifications;
    public InfrastructureContainer infrastructure;
    public StatisticsContainer statistics;

    private BitmovinApi() throws IOException
    {
        this.jacksonObjectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.jacksonObjectMapper.setDateFormat(ISO8601DateFormat.getDateTimeInstance());
        this.jacksonObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        this.jacksonObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Unirest.setObjectMapper(new ObjectMapper()
        {

            public <T> T readValue(String value, Class<T> valueType)
            {
                try
                {
                    return BitmovinApi.this.jacksonObjectMapper.readValue(value, valueType);
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value)
            {
                try
                {
                    String s = BitmovinApi.this.jacksonObjectMapper.writeValueAsString(value);
                    return s;
                }
                catch (JsonProcessingException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });
        String version = Runtime.class.getPackage().getImplementationVersion();
        if (version != null && version.startsWith("1.7.0"))
        {
            try
            {
                SSLContext context = SSLContext.getInstance("TLSv1.2");
                context.init(null, null, null);
                HttpClient httpClient = HttpClientBuilder
                        .create()
                        .setSSLContext(context)
                        .build();
                Unirest.setHttpClient(httpClient);
            }
            catch (KeyManagementException | NoSuchAlgorithmException e)
            {
                throw new IOException(e);
            }
        }
    }

    public BitmovinApi(String apiKey) throws IOException
    {
        this(apiKey, null, null, true);
    }

    public BitmovinApi(String apiKey, String tenantID) throws IOException
    {
        this(apiKey, null, tenantID, true);
    }

    public BitmovinApi(String apiKey, String apiUrl, boolean useHttps) throws IOException
    {
        this(apiKey, apiUrl, null, useHttps);
    }

    public BitmovinApi(String apiKey, String apiUrl, String tenantID, boolean useHttps) throws IOException
    {
        this();

        this.tenantID = tenantID;
        this.apiKey = apiKey;
        this.apiUrl = apiUrl == null ? ApiUrls.API_ENDPOINT_WITH_PROTOCOL + "/v1/" : String.format("%s://%s", useHttps ? "https" : "http", apiUrl);
        ApiUrls.API_ENDPOINT_WITH_PROTOCOL = this.apiUrl;

        this.setDefaultHeaders();
        this.initContainers();
    }

    public void setDebug(boolean debug)
    {
        RestClient.setDebug(debug);
    }

    public boolean isDebug()
    {
        return RestClient.isDebug();
    }

    private void setDefaultHeaders() throws IOException
    {
        this.defaultHeaders.put("Content-Type", "application/json");
        this.defaultHeaders.put("X-Api-Key", this.apiKey);
        if (this.tenantID != null)
        {
            this.defaultHeaders.put("X-Tenant-Org-Id", this.tenantID);
        }

        this.loadProperties();

        this.defaultHeaders.put("X-Api-Client", this.properties.getProperty(X_API_CLIENT_CONFIGURATION_KEY));
        this.defaultHeaders.put("X-Api-Client-Version", this.properties.getProperty(X_API_CLIENT_VERSION_CONFIGURATION_KEY));
    }

    private void loadProperties() throws IOException
    {
        this.properties = new Properties();
        InputStream inputStream = BitmovinApi.class.getClassLoader().getResourceAsStream("config.properties");

        if (inputStream == null)
        {
            this.properties.setProperty(X_API_CLIENT_CONFIGURATION_KEY, DEFAULT_X_API_CLIENT);
            this.properties.setProperty(X_API_CLIENT_VERSION_CONFIGURATION_KEY, DEFAULT_X_API_CLIENT_VERSION);
        }
        else
        {
            this.properties.load(inputStream);
        }
    }

    private void initContainers()
    {
        this.configuration = new ConfigurationContainer(this.defaultHeaders);
        this.analytics = new AnalyticsContainer(this.defaultHeaders);
        this.encoding = new EncodingResource(this.defaultHeaders, ApiUrls.encodings, Encoding.class);
        this.filter = new FilterContainer(this.defaultHeaders);
        this.input = new InputContainer(this.defaultHeaders);
        this.manifest = new ManifestContainer(this.defaultHeaders);
        this.output = new OutputContainer(this.defaultHeaders);
        this.storage = new StorageContainer(this.defaultHeaders);
        this.transfer = new TransferContainer(this.defaultHeaders);
        this.notifications = new NotificationContainer(this.defaultHeaders);
        this.infrastructure = new InfrastructureContainer(this.defaultHeaders);
        this.statistics = new StatisticsContainer(this.defaultHeaders);
    }

    public String getKey()
    {
        return this.apiKey;
    }

    public <T> T post(String resource, Map<String, String> additionalHeaders, Object content, Class<T> classOfT) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        if (additionalHeaders == null)
        {
            additionalHeaders = this.defaultHeaders;
        }
        else
        {
            additionalHeaders.putAll(this.defaultHeaders);
        }
        return RestClient.postRaw(resource, additionalHeaders, content, classOfT);
    }

    public <T> T get(String resource, Map<String, String> additionalHeaders, Class<T> classOfT) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return RestClient.getRaw(resource, additionalHeaders, classOfT);
    }

}
