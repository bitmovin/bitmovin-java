package com.bitmovin.api.encoding.outputs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;

/**
 * Created by arudich on 21.12.16.
 **/
public enum TransferVersion
{
    @JsonProperty("1.0.0")
    DEFAULT("1.0.0"),
    @JsonProperty("1.1.0")
    POOL("1.1.0");

    private String jsonValue;
    private static HashMap<String, TransferVersion> map;

    static
    {
        map = new HashMap<>(2);
        map.put(DEFAULT.jsonValue, DEFAULT);
        map.put(POOL.jsonValue, POOL);
    }

    TransferVersion(String jsonValue)
    {
        this.jsonValue = jsonValue;
    }

    @JsonCreator
    public static TransferVersion forValue(String jsonValue)
    {
        return map.get(jsonValue);
    }

    @JsonValue
    @Override
    public String toString()
    {
        return this.jsonValue;
    }


}
