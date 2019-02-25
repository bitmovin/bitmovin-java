package com.bitmovin.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonEncoder;

public class BitmovinApiClientFactoryImpl implements BitmovinApiClientFactory
{
    private final String apiKey;
    private String tenantOrgId;
    private Logger logger = new Logger.NoOpLogger();
    private Logger.Level logLevel = Logger.Level.NONE;
    private String baseUrl = "https://api.bitmovin.com/v1";

    public BitmovinApiClientFactoryImpl(String apiKey, String tenantOrgId)
    {
        if (apiKey == null || apiKey.isEmpty())
        {
            throw new IllegalArgumentException("Parameter 'apiKey' may not be null or empty.");
        }

        this.apiKey = apiKey;
        this.tenantOrgId = tenantOrgId;
    }

    public BitmovinApiClientFactoryImpl withLogging(Logger logger, Logger.Level logLevel)
    {
        if (logger == null)
        {
            throw new IllegalArgumentException("Parameter 'logger' may not be null.");
        }

        if (logLevel == null)
        {
            throw new IllegalArgumentException("Parameter 'logLevel' may not be null.");
        }

        this.logger = logger;
        this.logLevel = logLevel;

        return this;
    }

    public BitmovinApiClientFactoryImpl withBaseUrl(String baseUrl)
    {
        if (baseUrl == null || baseUrl.isEmpty())
        {
            throw new IllegalArgumentException("Parameter 'baseUrl' may not be null or empty.");
        }

        this.baseUrl = baseUrl;

        return this;
    }

    @Override
    public <T> T createApiClient(Class<T> apiClientClass) {
        ObjectMapper mapper = createObjectMapper();
        Feign.Builder feignBuilder = createFeignBuilder(mapper);

        return feignBuilder.target(apiClientClass, baseUrl);
    }

    protected ObjectMapper createObjectMapper() {
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected Feign.Builder createFeignBuilder(ObjectMapper mapper) {
        return Feign.builder()
                    .encoder(new JacksonEncoder(mapper))
                    .decoder(new BitmovinDecoder(mapper))
                    .errorDecoder(new BitmovinErrorDecoder(mapper))
                    .logger(this.logger)
                    .logLevel(this.logLevel)
                    .requestInterceptor(new BitmovinHeadersInterceptor(this.apiKey, this.tenantOrgId));
    }
}
