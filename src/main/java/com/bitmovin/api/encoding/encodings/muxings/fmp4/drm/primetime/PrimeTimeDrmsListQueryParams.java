package com.bitmovin.api.encoding.encodings.muxings.fmp4.drm.primetime;

import java.util.HashMap;
import com.bitmovin.api.model.*;

public class PrimeTimeDrmsListQueryParams extends HashMap<String, Object> {

    public void getOffset() {
        this.get("offset");
    }

    /**
    * @param offset TODO Add description (optional)
    */
    public void setOffset(String offset) {
        this.put("offset", offset);
    }

    public void getLimit() {
        this.get("limit");
    }

    /**
    * @param limit TODO Add description (optional)
    */
    public void setLimit(String limit) {
        this.put("limit", limit);
    }
}
