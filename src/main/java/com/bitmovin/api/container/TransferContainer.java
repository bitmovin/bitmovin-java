package com.bitmovin.api.container;

import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.encodings.transfer.EncodingTransfer;
import com.bitmovin.api.encoding.encodings.transfer.ManifestTransfer;
import com.bitmovin.api.resource.TransferResource;

import java.util.Map;

/**
 * Created by arudich on 15.09.16.
 **/
public class TransferContainer
{
    public TransferResource<EncodingTransfer> encoding;
    public TransferResource<ManifestTransfer> manifest;

    public TransferContainer(Map<String, String> headers)
    {
        this.encoding = new TransferResource<>(headers, ApiUrls.transferEncoding, EncodingTransfer.class);
        this.manifest = new TransferResource<>(headers, ApiUrls.transferManifest, ManifestTransfer.class);
    }
}
