package com.bitmovin.api.http.utils;

import com.mashape.unirest.http.HttpResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResponseLogger
{
    private static final Logger logger = LoggerFactory.getLogger(RequestLogger.class);

    public static void logRawResponse(HttpResponse<String> response)
    {
        String responseLog = "\nResponse:" +
                "\n--------------------------------------------------------------------\n" +
                "STATUS: " + response.getStatus() + " - " + response.getStatusText() + "\n" +
                "HEADERS: " + response.getHeaders() + "\n";
        try
        {
            String rawBody = IOUtils.toString(response.getRawBody(), StandardCharsets.UTF_8);
            if (StringUtils.isNotBlank(rawBody))
            {
                responseLog += "PAYLOAD: \n" + rawBody + "\n";
            }
            else
            {
                responseLog += "PAYLOAD: <EMPTY>\n";
            }
            responseLog += "--------------------------------------------------------------------\n";
            logger.info(responseLog);
        }
        catch (IOException e)
        {
            responseLog +=
                    "PAYLOAD: <NOT PARSABLE>\n" +
                    "--------------------------------------------------------------------\n";
            logger.info(responseLog);
        }
    }
}
