package com.bitmovin.api;

import org.json.JSONObject;

public interface ITypeCallback
{
    Class getClazz(JSONObject object);
}
