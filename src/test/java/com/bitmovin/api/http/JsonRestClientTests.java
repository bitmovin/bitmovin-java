package com.bitmovin.api.http;

import com.bitmovin.api.exceptions.BitmovinApiException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class JsonRestClientTests
{
    @Test
    public void testGetRequestWithUnirestErrorAndRetryOnErrorTrueGetsRetriedAndThrowsCorrectError() throws URISyntaxException, BitmovinApiException
    {
        URI requestUri = new URI("http://something.that.doesnt.exist");
        Map<String, String> requestHeaders = new HashMap<>();

        JsonRestClient jsonRestClient = new JsonRestClient(true, true);
        jsonRestClient.setMaxRetries(3);
        jsonRestClient.setMsToWaitForRetrying(100);

        try
        {
            jsonRestClient.get(requestUri, requestHeaders);
        }
        catch (UnirestException e)
        {
            Assert.assertEquals("Couldn't successfully perform HttpRequest after 3 retries", e.getMessage());
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithMaxRetriesLowerThanZeroThrowsCorrectError() throws URISyntaxException, BitmovinApiException
    {
        URI requestUri = new URI("http://something.that.doesnt.exist");
        Map<String, String> requestHeaders = new HashMap<>();

        JsonRestClient jsonRestClient = new JsonRestClient(true, true);
        jsonRestClient.setMaxRetries(-1);
        jsonRestClient.setMsToWaitForRetrying(100);

        try
        {
            jsonRestClient.get(requestUri, requestHeaders);
        }
        catch (UnirestException e)
        {
            Assert.assertTrue(e.getMessage().contains("java.net.UnknownHostException: something.that.doesnt.exist"));
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithMsToWaitForRetryingLowerThanZeroThrowsCorrectError() throws URISyntaxException, BitmovinApiException
    {
        URI requestUri = new URI("http://something.that.doesnt.exist");
        Map<String, String> requestHeaders = new HashMap<>();

        JsonRestClient jsonRestClient = new JsonRestClient(true, true);
        jsonRestClient.setMaxRetries(5);
        jsonRestClient.setMsToWaitForRetrying(-1);

        try
        {
            jsonRestClient.get(requestUri, requestHeaders);
        }
        catch (UnirestException e)
        {
            Assert.assertTrue(e.getMessage().contains("java.net.UnknownHostException: something.that.doesnt.exist"));
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

    @Test
    public void testGetRequestWithUnirestErrorAndRetyOnErrorFalseGetsNotRetried() throws URISyntaxException, BitmovinApiException
    {
        JsonRestClient jsonRestClient = new JsonRestClient(true, true);

        try
        {
            jsonRestClient.get(new URI("http://something.that.doesnt.exist"), new HashMap<String, String>());
        }
        catch (UnirestException e)
        {
            Assert.assertTrue(e.getMessage().contains("java.net.UnknownHostException: something.that.doesnt.exist"));
            return;
        }
        Assert.fail("Should have thrown UnirestException");
    }

}
