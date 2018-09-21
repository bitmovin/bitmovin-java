package com.bitmovin.api.http.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RequestLogger
{

  private static final Logger logger = LoggerFactory.getLogger(RequestLogger.class);
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static void logRequest(String method, String uri, Map<String, String> headers) {
    logRequest(method, uri, null, headers);
  }

  public static void logRequest(String method, String uri, Object payload,
                                Map<String, String> headers) {
    String request = "\nRequest:" +
        "\n--------------------------------------------------------------------\n" +
        "HTTP Method: " + method + "\n" +
        "REST URI: " + uri + "\n" +
        "HEADERS: " + headers + "\n";

    if (payload != null) {
      try {
        request += "PAYLOAD: \n" + objectMapper.writerWithDefaultPrettyPrinter()
            .writeValueAsString(payload) + "\n";
      } catch (JsonProcessingException e) {
        logger.error("Error serializing payload for logging!", e);
      }
    }
    request += "--------------------------------------------------------------------\n";
    logger.info(request);
  }
}
