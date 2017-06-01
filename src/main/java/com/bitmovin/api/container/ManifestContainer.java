package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.manifest.Manifest;
import com.bitmovin.api.encoding.manifest.dash.DashManifest;
import com.bitmovin.api.encoding.manifest.hls.HlsManifest;
import com.bitmovin.api.encoding.manifest.smooth.SmoothStreamingManifest;
import com.bitmovin.api.resource.ManifestDashResource;
import com.bitmovin.api.resource.ManifestHlsResource;
import com.bitmovin.api.resource.ManifestResource;
import com.bitmovin.api.resource.ManifestSmoothResource;

import java.util.Map;

import static com.bitmovin.api.constants.ApiUrls.manifestDash;
import static com.bitmovin.api.constants.ApiUrls.manifestDashStart;
import static com.bitmovin.api.constants.ApiUrls.manifestDashStatus;
import static com.bitmovin.api.constants.ApiUrls.manifestHls;
import static com.bitmovin.api.constants.ApiUrls.manifestHlsStart;
import static com.bitmovin.api.constants.ApiUrls.manifestHlsStatus;
import static com.bitmovin.api.constants.ApiUrls.manifestSmooth;
import static com.bitmovin.api.constants.ApiUrls.manifestSmoothStart;
import static com.bitmovin.api.constants.ApiUrls.manifestSmoothStatus;

/**
 * Created by rkersche on 9/5/16.
 */
public class ManifestContainer
{
    public ManifestDashResource dash;
    public ManifestHlsResource hls;
    public ManifestSmoothResource smooth;
    public ManifestResource<Manifest> all;
    private Map<String, String> headers;

    public ManifestContainer(Map<String, String> headers)
    {
        this.dash = new ManifestDashResource(headers, manifestDash, DashManifest.class, manifestDashStatus, manifestDashStart);
        this.hls = new ManifestHlsResource(headers, manifestHls, HlsManifest.class, manifestHlsStatus, manifestHlsStart);
        this.smooth = new ManifestSmoothResource(headers, manifestSmooth, SmoothStreamingManifest.class, manifestSmoothStatus, manifestSmoothStart);
        this.all = new ManifestResource<>(headers, ApiUrls.manifests, Manifest.class);
        this.headers = headers;
    }

}
