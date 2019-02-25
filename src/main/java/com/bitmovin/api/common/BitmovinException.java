package com.bitmovin.api.common;

import java.util.List;

public class BitmovinException extends Exception {
    private int httpStatusCode;
    private int errorCode;
    private String developerMessage;
    private List<BitmovinErrorDetails> details;
    private String rawJson;

    public BitmovinException() {
    }

    public BitmovinException(String message) {
        super(message);
    }

    public BitmovinException(String message, int httpStatusCode) {
        super(message);

        this.httpStatusCode = httpStatusCode;
    }

    public BitmovinException(String message, int httpStatusCode, int errorCode, String developerMessage, List<BitmovinErrorDetails> details, String rawJson) {
        super(message);

        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.developerMessage = developerMessage;
        this.details = details;
        this.rawJson = rawJson;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public List<BitmovinErrorDetails> getDetails() {
        return details;
    }

    public String getRawJson() {
        return rawJson;
    }
}
