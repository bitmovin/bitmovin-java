package com.bitmovin.api.http;

import com.bitmovin.api.SampleProvider;
import com.bitmovin.api.http.exceptions.RestClientException;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;

import java.util.HashMap;
import java.util.Map;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.verify.VerificationTimes.exactly;

public class UnirestRestClientTests
{
    private static ClientAndProxy proxy;

    private ClientAndServer mockServer;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public static void startProxy()
    {
        proxy = ClientAndProxy.startClientAndProxy(1090);
    }

    @AfterClass
    public static void stopProxy()
    {
        proxy.stop();
    }

    @Before
    public void startMockServer()
    {
        this.mockServer = ClientAndServer.startClientAndServer(1080);
        proxy.reset();
    }

    @After
    public void stopMockServer()
    {
        this.mockServer.stop();
    }

    @Test
    public void testGetRequestWith500ResponseGetsRetriedAndThrowsError()
    {
        String errorResponse = "This is an 500 internal server error response";
        this.mockServer.when(
                request().withPath("/error")
        ).respond(
                response(errorResponse).withStatusCode(500)
        );

        UnirestRestClient unirestRestClient = new UnirestRestClient(this.objectMapper, true, true);
        unirestRestClient.setMaxRetries(3);
        unirestRestClient.setMsToWaitForRetrying(100);

        Map<String, String> requestHeaders = new HashMap<>();
        try
        {
            unirestRestClient.getAsObject("http://localhost:1080/error", requestHeaders, Object.class);
            this.mockServer.verify(
                    request().withPath("/error"),
                    exactly(3)
            );
        }
        catch (RestClientException e)
        {
            Assert.assertEquals((long) 500, (long) e.getStatusCode());
            Assert.assertEquals(errorResponse, e.getRawBody());
            Assert.assertEquals(e.getMessage(), "Got 5xx server error responses while performing 'GET' to url 'http://localhost:1080/error' after 3 retries");
            return;
        }
        Assert.fail("Should have thrown RestClientException");
    }

    @Test
    public void testGetRequestWith500ResponseGetsNotRetriedIfRetryIsFalseAndThrowsError()
    {
        String errorResponse = "This is an 500 internal server error response";
        this.mockServer.when(
                request().withPath("/error")
        ).respond(
                response(errorResponse).withStatusCode(500)
        );

        UnirestRestClient unirestRestClient = new UnirestRestClient(this.objectMapper, true, false);

        Map<String, String> requestHeaders = new HashMap<>();
        try
        {
            unirestRestClient.getAsObject("http://localhost:1080/error", requestHeaders, Object.class);
            this.mockServer.verify(
                    request().withPath("/error"),
                    exactly(1)
            );
        }
        catch (RestClientException e)
        {
            Assert.assertEquals((long) 500, (long) e.getStatusCode());
            Assert.assertEquals(errorResponse, e.getRawBody());
            Assert.assertEquals(e.getMessage(), "Error response from REST call");
            return;
        }
        Assert.fail("Should have thrown RestClientException");
    }

    @Test
    public void testGetRequestWith400ResponseGetsNotRetriedAndThrowsError() throws JsonProcessingException
    {
        String badRequestResponse = this.objectMapper.writeValueAsString(
                SampleProvider.sampleBadRequestResponse()
        );
        this.mockServer.when(
                request().withPath("/bad-request")
        ).respond(
                response(badRequestResponse).withStatusCode(400)
        );

        UnirestRestClient unirestRestClient = new UnirestRestClient(new ObjectMapper(), true, true);
        unirestRestClient.setMaxRetries(3);
        unirestRestClient.setMsToWaitForRetrying(100);

        Map<String, String> requestHeaders = new HashMap<>();
        try
        {
            unirestRestClient.getAsObject("http://localhost:1080/bad-request", requestHeaders, Object.class);
            this.mockServer.verify(
                    request().withPath("/bad-request"),
                    exactly(1)
            );
        }
        catch (RestClientException e)
        {
            Assert.assertEquals((long) 400, (long) e.getStatusCode());
            Assert.assertEquals("Error response from REST call", e.getMessage());
            Assert.assertEquals(badRequestResponse, e.getRawBody());
            return;
        }
        Assert.fail("Should have thrown RestClientException");
    }

    @Test
    public void testGetRequestWith200ResponseGetsNotRetriedAndReturnsCorrectResponse() throws JsonProcessingException
    {
        String successResponse = this.objectMapper.writeValueAsString(
                SampleProvider.sampleSuccessResponse()
        );
        this.mockServer.when(
                request().withPath("/ok")
        ).respond(
                response(successResponse).withStatusCode(200)
        );

        UnirestRestClient unirestRestClient = new UnirestRestClient(new ObjectMapper(), true, true);
        unirestRestClient.setMaxRetries(3);
        unirestRestClient.setMsToWaitForRetrying(100);

        Map<String, String> requestHeaders = new HashMap<>();
        try
        {
            ResponseEnvelope response = unirestRestClient.getAsObject("http://localhost:1080/ok", requestHeaders, ResponseEnvelope.class);
            this.mockServer.verify(
                    request().withPath("/ok"),
                    exactly(1)
            );

            Assert.assertEquals("SUCCESS", response.getStatus().toString());
        }
        catch (RestClientException e)
        {
            Assert.fail("Should not have thrown RestClientException");
        }
    }
}
