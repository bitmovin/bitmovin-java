package com.bitmovin.api.container;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.filters.AudioMixFilter;
import com.bitmovin.api.encoding.filters.CropFilter;
import com.bitmovin.api.encoding.filters.DeinterlaceFilter;
import com.bitmovin.api.encoding.filters.Filter;
import com.bitmovin.api.encoding.filters.RotateFilter;
import com.bitmovin.api.encoding.filters.WatermarkFilter;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.resource.FilterResource;
import com.bitmovin.api.rest.ResponseEnvelope;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class FilterContainer
{

    public FilterResource<CropFilter> crop;
    public FilterResource<RotateFilter> rotate;
    public FilterResource<WatermarkFilter> watermark;
    public FilterResource<DeinterlaceFilter> deinterlace;
    public FilterResource<AudioMixFilter> audioMix;
    public FilterResource<Filter> all;
    private Map<String, String> headers;


    public FilterContainer(Map<String, String> headers)
    {
        this.headers = headers;
        this.crop = new FilterResource<>(headers, ApiUrls.filterCrop, CropFilter.class);
        this.rotate = new FilterResource<>(headers, ApiUrls.filterRotate, RotateFilter.class);
        this.watermark = new FilterResource<>(headers, ApiUrls.filterWatermark, WatermarkFilter.class);
        this.deinterlace = new FilterResource<>(headers, ApiUrls.filterDeinterlace, DeinterlaceFilter.class);
        this.audioMix = new FilterResource<>(headers, ApiUrls.filterAudioMix, AudioMixFilter.class);
        this.all = new FilterResource<>(headers, ApiUrls.filters, Filter.class);
    }

    public int getTotalFiltersCount() throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        ResponseEnvelope responseEnvelope = RestClient.getRaw(ApiUrls.filters, this.headers, ResponseEnvelope.class);
        JSONObject responseObject = RestClient.convertToJsonObject(responseEnvelope);
        return responseObject.getJSONObject("data").getJSONObject("result").getInt("totalCount");
    }

}
