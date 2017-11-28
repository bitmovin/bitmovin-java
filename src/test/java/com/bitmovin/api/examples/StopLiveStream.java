package com.bitmovin.api.examples;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.bitmovin.api.BitmovinApi;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.status.Task;
import com.bitmovin.api.enums.Status;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by Germano Fronza on 27.11.17.
 **/
public class StopLiveStream
{
	private static final String API_KEY = "<INSERT_YOUR_API_KEY>";

	private static BitmovinApi bitmovinApi;

	@Test
	public void testStopLiveStream() throws IOException, BitmovinApiException, UnirestException, URISyntaxException,
			RestException, InterruptedException
	{
		bitmovinApi = new BitmovinApi(API_KEY);

		Encoding encoding = bitmovinApi.encoding.get("<YOUR_ENCODING_ID>");

		bitmovinApi.encoding.stopLive(encoding.getId());

		Task status = bitmovinApi.encoding.getStatus(encoding);

		while (status.getStatus() != Status.FINISHED && status.getStatus() != Status.ERROR)
		{
			status = bitmovinApi.encoding.getStatus(encoding);
			Thread.sleep(2500);
		}

		System.out.println(String.format("Live stream has reached final status: %s", status.toString()));
	}

}
