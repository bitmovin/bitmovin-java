package com.bitmovin.api.encoding.configurations.audio.eac3;

import java.util.HashMap;
import com.bitmovin.api.model.*;

public class Eac3AudioConfigurationsListQueryParams extends HashMap<String, Object> {

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

    public void getName() {
        this.get("name");
    }

    /**
    * @param name Filter configuration by name (optional)
    */
    public void setName(String name) {
        this.put("name", name);
    }
}
