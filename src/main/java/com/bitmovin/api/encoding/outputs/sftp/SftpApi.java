package com.bitmovin.api.encoding.outputs.sftp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.sftp.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SftpApi
{
    private final SftpClient apiClient;
    public CustomdataApi customdata;

    public SftpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public SftpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public SftpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(SftpClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create SFTP Output
    * 
    * @param sftpOutput The SFTP output to be created. (optional)
    * @return SftpOutput
    * @throws BitmovinException if fails to make API call
    */
    public SftpOutput create(SftpOutput sftpOutput) throws BitmovinException
    {
        return this.apiClient.create(sftpOutput);
    }

    /**
    * Delete SFTP Output
    * 
    * @param outputId Id of the output (required)
    * @return SftpOutput
    * @throws BitmovinException if fails to make API call
    */
    public SftpOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * SFTP Output Details
    * 
    * @param outputId Id of the output (required)
    * @return SftpOutput
    * @throws BitmovinException if fails to make API call
    */
    public SftpOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List SFTP Outputs
    * 
    * @return List&lt;SftpOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SftpOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List SFTP Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SftpOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SftpOutput> list(SftpOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
