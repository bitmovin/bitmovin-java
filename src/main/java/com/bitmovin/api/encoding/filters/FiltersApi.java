package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.filters.watermark.WatermarkApi;
import com.bitmovin.api.encoding.filters.audioVolume.AudioVolumeApi;
import com.bitmovin.api.encoding.filters.enhancedWatermark.EnhancedWatermarkApi;
import com.bitmovin.api.encoding.filters.crop.CropApi;
import com.bitmovin.api.encoding.filters.rotate.RotateApi;
import com.bitmovin.api.encoding.filters.deinterlace.DeinterlaceApi;
import com.bitmovin.api.encoding.filters.audioMix.AudioMixApi;
import com.bitmovin.api.encoding.filters.denoiseHqdn3d.DenoiseHqdn3dApi;
import com.bitmovin.api.encoding.filters.text.TextApi;
import com.bitmovin.api.encoding.filters.interlace.InterlaceApi;
import com.bitmovin.api.encoding.filters.unsharp.UnsharpApi;
import com.bitmovin.api.encoding.filters.scale.ScaleApi;
import com.bitmovin.api.encoding.filters.type.TypeApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiltersApi
{
    private final FiltersClient apiClient;
    public WatermarkApi watermark;
    public AudioVolumeApi audioVolume;
    public EnhancedWatermarkApi enhancedWatermark;
    public CropApi crop;
    public RotateApi rotate;
    public DeinterlaceApi deinterlace;
    public AudioMixApi audioMix;
    public DenoiseHqdn3dApi denoiseHqdn3d;
    public TextApi text;
    public InterlaceApi interlace;
    public UnsharpApi unsharp;
    public ScaleApi scale;
    public TypeApi type;

    public FiltersApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public FiltersApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public FiltersApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(FiltersClient.class);

        watermark = new WatermarkApi(clientFactory);
        audioVolume = new AudioVolumeApi(clientFactory);
        enhancedWatermark = new EnhancedWatermarkApi(clientFactory);
        crop = new CropApi(clientFactory);
        rotate = new RotateApi(clientFactory);
        deinterlace = new DeinterlaceApi(clientFactory);
        audioMix = new AudioMixApi(clientFactory);
        denoiseHqdn3d = new DenoiseHqdn3dApi(clientFactory);
        text = new TextApi(clientFactory);
        interlace = new InterlaceApi(clientFactory);
        unsharp = new UnsharpApi(clientFactory);
        scale = new ScaleApi(clientFactory);
        type = new TypeApi(clientFactory);
    }

    /**
    * List all Filters
    * 
    * @return List&lt;Filter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Filter> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List all Filters
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Filter&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Filter> list(FiltersListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
