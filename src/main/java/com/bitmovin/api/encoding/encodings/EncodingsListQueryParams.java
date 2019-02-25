package com.bitmovin.api.encoding.encodings;

import java.util.HashMap;
import com.bitmovin.api.model.*;

public class EncodingsListQueryParams extends HashMap<String, Object> {

    public void getOffset() {
        this.get("offset");
    }

    /**
    * @param offset Index of the first item to return, starting at 0. Default is 0 (optional)
    */
    public void setOffset(Integer offset) {
        this.put("offset", offset);
    }

    public void getLimit() {
        this.get("limit");
    }

    /**
    * @param limit Maximum number of items to return. Default is 25, maximum is 100 (optional)
    */
    public void setLimit(Integer limit) {
        this.put("limit", limit);
    }

    public void getSort() {
        this.get("sort");
    }

    /**
    * @param sort Order list result according an encoding resource attribute (optional)
    */
    public void setSort(String sort) {
        this.put("sort", sort);
    }

    public void getType() {
        this.get("type");
    }

    /**
    * @param type Filter encodings to only show the ones with the type specified. (optional)
    */
    public void setType(String type) {
        this.put("type", type);
    }

    public void getStatus() {
        this.get("status");
    }

    /**
    * @param status Filter encodings to only show the ones with the status specified. (optional)
    */
    public void setStatus(String status) {
        this.put("status", status);
    }

    public void getCloudRegion() {
        this.get("cloudRegion");
    }

    /**
    * @param cloudRegion Filter encodings to only show the ones with the cloudRegion specified. (optional, default to null)
    */
    public void setCloudRegion(CloudRegion cloudRegion) {
        this.put("cloudRegion", cloudRegion);
    }

    public void getEncoderVersion() {
        this.get("encoderVersion");
    }

    /**
    * @param encoderVersion Filter encodings to only show the ones with the encoderVersion specified. (optional)
    */
    public void setEncoderVersion(String encoderVersion) {
        this.put("encoderVersion", encoderVersion);
    }

    public void getName() {
        this.get("name");
    }

    /**
    * @param name Filter encodings by name (optional)
    */
    public void setName(String name) {
        this.put("name", name);
    }
}
