package com.bitmovin.api.encoding.statistics.labels.daily;

import java.util.HashMap;
import com.bitmovin.api.model.*;

public class DailyStatisticsPerLabelsListQueryParams extends HashMap<String, Object> {

    public void getOffset() {
        this.get("offset");
    }

    /**
    * @param offset Index of the first item to return, starting at 0. Default is 0 (optional)
    */
    public void setOffset(Long offset) {
        this.put("offset", offset);
    }

    public void getLimit() {
        this.get("limit");
    }

    /**
    * @param limit Maximum number of items to return. Default is 25, maximum is 100 (optional)
    */
    public void setLimit(Long limit) {
        this.put("limit", limit);
    }

    public void getLabels() {
        this.get("labels");
    }

    /**
    * @param labels Comma separated list of labels. Filter results to only show the ones specified (optional)
    */
    public void setLabels(String labels) {
        this.put("labels", labels);
    }
}
