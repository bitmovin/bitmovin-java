package com.bitmovin.api.encoding.outputs;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.type.TypeApi;
import com.bitmovin.api.encoding.outputs.s3.S3Api;
import com.bitmovin.api.encoding.outputs.s3RoleBased.S3RoleBasedApi;
import com.bitmovin.api.encoding.outputs.genericS3.GenericS3Api;
import com.bitmovin.api.encoding.outputs.local.LocalApi;
import com.bitmovin.api.encoding.outputs.gcs.GcsApi;
import com.bitmovin.api.encoding.outputs.azure.AzureApi;
import com.bitmovin.api.encoding.outputs.ftp.FtpApi;
import com.bitmovin.api.encoding.outputs.sftp.SftpApi;
import com.bitmovin.api.encoding.outputs.akamaiNetstorage.AkamaiNetstorageApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputsApi
{
    private final OutputsClient apiClient;
    public TypeApi type;
    public S3Api s3;
    public S3RoleBasedApi s3RoleBased;
    public GenericS3Api genericS3;
    public LocalApi local;
    public GcsApi gcs;
    public AzureApi azure;
    public FtpApi ftp;
    public SftpApi sftp;
    public AkamaiNetstorageApi akamaiNetstorage;

    public OutputsApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public OutputsApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public OutputsApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(OutputsClient.class);

        type = new TypeApi(clientFactory);
        s3 = new S3Api(clientFactory);
        s3RoleBased = new S3RoleBasedApi(clientFactory);
        genericS3 = new GenericS3Api(clientFactory);
        local = new LocalApi(clientFactory);
        gcs = new GcsApi(clientFactory);
        azure = new AzureApi(clientFactory);
        ftp = new FtpApi(clientFactory);
        sftp = new SftpApi(clientFactory);
        akamaiNetstorage = new AkamaiNetstorageApi(clientFactory);
    }

    /**
    * List all Outputs
    * 
    * @return List&lt;Output&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Output> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List all Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;Output&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<Output> list(OutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
