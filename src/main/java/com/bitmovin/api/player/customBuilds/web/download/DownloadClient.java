package com.bitmovin.api.player.customBuilds.web.download;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import feign.Body;
import feign.Headers;

import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Map;


public interface DownloadClient {
    
    @RequestLine("GET /player/custom-builds/web/{custom_build_id}/download")
    CustomPlayerBuildDownload get(@Param("custom_build_id") String customBuildId) throws BitmovinException;
}
