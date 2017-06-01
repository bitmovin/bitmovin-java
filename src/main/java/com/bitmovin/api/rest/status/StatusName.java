package com.bitmovin.api.rest.status;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 26.08.16.
 */
public enum StatusName
{
    CREATED,
    QUEUED,
    RUNNING,
    FINISHED,
    ERROR;

    StatusName() {
    }
}
