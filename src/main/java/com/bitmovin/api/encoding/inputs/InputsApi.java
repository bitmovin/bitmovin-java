package com.bitmovin.api.encoding.inputs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.type.TypeApi;
import com.bitmovin.api.encoding.inputs.rtmp.RtmpApi;
import com.bitmovin.api.encoding.inputs.redundantRtmp.RedundantRtmpApi;
import com.bitmovin.api.encoding.inputs.s3.S3Api;
import com.bitmovin.api.encoding.inputs.s3RoleBased.S3RoleBasedApi;
import com.bitmovin.api.encoding.inputs.genericS3.GenericS3Api;
import com.bitmovin.api.encoding.inputs.local.LocalApi;
import com.bitmovin.api.encoding.inputs.gcs.GcsApi;
import com.bitmovin.api.encoding.inputs.azure.AzureApi;
import com.bitmovin.api.encoding.inputs.ftp.FtpApi;
import com.bitmovin.api.encoding.inputs.sftp.SftpApi;
import com.bitmovin.api.encoding.inputs.http.HttpApi;
import com.bitmovin.api.encoding.inputs.https.HttpsApi;
import com.bitmovin.api.encoding.inputs.aspera.AsperaApi;
import com.bitmovin.api.encoding.inputs.akamaiNetstorage.AkamaiNetstorageApi;
import com.bitmovin.api.encoding.inputs.tcp.TcpApi;
import com.bitmovin.api.encoding.inputs.udp.UdpApi;
import com.bitmovin.api.encoding.inputs.udpMulticast.UdpMulticastApi;
import com.bitmovin.api.encoding.inputs.zixi.ZixiApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputsApi
{
    private final InputsClient apiClient;
    public TypeApi type;
    public RtmpApi rtmp;
    public RedundantRtmpApi redundantRtmp;
    public S3Api s3;
    public S3RoleBasedApi s3RoleBased;
    public GenericS3Api genericS3;
    public LocalApi local;
    public GcsApi gcs;
    public AzureApi azure;
    public FtpApi ftp;
    public SftpApi sftp;
    public HttpApi http;
    public HttpsApi https;
    public AsperaApi aspera;
    public AkamaiNetstorageApi akamaiNetstorage;
    public TcpApi tcp;
    public UdpApi udp;
    public UdpMulticastApi udpMulticast;
    public ZixiApi zixi;

    public InputsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public InputsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public InputsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(InputsClient.class);

        type = new TypeApi(clientFactory);
        rtmp = new RtmpApi(clientFactory);
        redundantRtmp = new RedundantRtmpApi(clientFactory);
        s3 = new S3Api(clientFactory);
        s3RoleBased = new S3RoleBasedApi(clientFactory);
        genericS3 = new GenericS3Api(clientFactory);
        local = new LocalApi(clientFactory);
        gcs = new GcsApi(clientFactory);
        azure = new AzureApi(clientFactory);
        ftp = new FtpApi(clientFactory);
        sftp = new SftpApi(clientFactory);
        http = new HttpApi(clientFactory);
        https = new HttpsApi(clientFactory);
        aspera = new AsperaApi(clientFactory);
        akamaiNetstorage = new AkamaiNetstorageApi(clientFactory);
        tcp = new TcpApi(clientFactory);
        udp = new UdpApi(clientFactory);
        udpMulticast = new UdpMulticastApi(clientFactory);
        zixi = new ZixiApi(clientFactory);
    }

    /**
    * List all Inputs
    * 
    * @return List&lt;Input&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Input> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List all Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Input&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Input> list(InputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
