package com.bitmovin.api.http;

import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndProxy;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpResponse;

import static org.mockserver.integration.ClientAndProxy.startClientAndProxy;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.verify.VerificationTimes.exactly;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class JsonRestClientTests
{
    private ClientAndServer mockServer;
    private static ClientAndProxy proxy;

    @Before
    public void startProxy() {
        mockServer = startClientAndServer(1080);
        proxy = startClientAndProxy(1090);

        mockServer.when(
                request().withPath("/error")
        ).respond(
                HttpResponse.response().withStatusCode(500)
        );
        mockServer.when(
                request().withPath("/notfound")
        ).respond(
                HttpResponse.notFoundResponse()
        );
    }

    @After
    public void stopProxy() {
        proxy.stop();
        mockServer.stop();
    }

    @Test
    public void testGetRequestWithUnirestErrorAndRetryOnErrorTrueGetsRetriedAndThrowsCorrectError() throws URISyntaxException, BitmovinApiException
    {
        URI requestUri = new URI("http://localhost:1080/error");
        Map<String, String> requestHeaders = new HashMap<>();

        JsonRestClient jsonRestClient = new JsonRestClient(true, true);
        jsonRestClient.setMaxRetries(3);
        jsonRestClient.setMsToWaitForRetrying(100);

        try
        {
            jsonRestClient.get(requestUri, requestHeaders);
            proxy.verify(
                    request()
                            .withPath("/error"),
                    exactly(3)
            );
        }
        catch (UnirestException e)
        {
            Assert.assertEquals("Couldn't successfully perform HttpRequest after 3 retries. Seems there are problems with our infrastructure. Please try again later.", e.getMessage());
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithMaxRetriesLowerThanZeroGetsNotRetriedAndThrowsCorrectError() throws URISyntaxException, BitmovinApiException
    {
        URI requestUri = new URI("http://localhost:1080/error");
        Map<String, String> requestHeaders = new HashMap<>();

        JsonRestClient jsonRestClient = new JsonRestClient(true, true);
        jsonRestClient.setMaxRetries(-1);
        jsonRestClient.setMsToWaitForRetrying(100);

        try
        {
            jsonRestClient.get(requestUri, requestHeaders);
            proxy.verify(
                    request()
                            .withPath("/error"),
                    exactly(1)
            );
        }
        catch (UnirestException e)
        {
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithMsToWaitForRetryingLowerThanZeroThrowsCorrectError() throws URISyntaxException, BitmovinApiException
    {
        URI requestUri = new URI("http://localhost:1080/error");
        Map<String, String> requestHeaders = new HashMap<>();

        JsonRestClient jsonRestClient = new JsonRestClient(true, true);
        jsonRestClient.setMaxRetries(5);
        jsonRestClient.setMsToWaitForRetrying(-1);

        try
        {
            jsonRestClient.get(requestUri, requestHeaders);
            proxy.verify(
                    request()
                            .withPath("/error"),
                    exactly(1)
            );
        }
        catch (UnirestException e)
        {
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithErrorResponseAndRetyOnErrorFalseGetsNotRetried() throws URISyntaxException, BitmovinApiException
    {
        JsonRestClient jsonRestClient = new JsonRestClient(true, false);

        try
        {
            jsonRestClient.get(new URI("http://localhost:1080/error"), new HashMap<String, String>());
            proxy.verify(
                    request()
                            .withPath("/error"),
                    exactly(1)
            );
        }
        catch (UnirestException e)
        {
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithNotFoundResponseAndRetyOnErrorTrueGetsNotRetried() throws URISyntaxException, BitmovinApiException
    {
        JsonRestClient jsonRestClient = new JsonRestClient(true, true);

        try
        {
            jsonRestClient.get(new URI("http://localhost:1080/notfound"), new HashMap<String, String>());
            proxy.verify(
                    request()
                            .withPath("/notfound"),
                    exactly(1)
            );
        }
        catch (UnirestException e)
        {
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

}
