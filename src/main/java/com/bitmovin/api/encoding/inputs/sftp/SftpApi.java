package com.bitmovin.api.encoding.inputs.sftp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.sftp.customdata.CustomdataApi;

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
    * Create SFTP Input
    * 
    * @param sftpInput The SFTP input to be created (optional)
    * @return SftpInput
    * @throws BitmovinException if fails to make API call
    */
    public SftpInput create(SftpInput sftpInput) throws BitmovinException
    {
        return this.apiClient.create(sftpInput);
    }

    /**
    * Delete SFTP Input
    * 
    * @param inputId Id of the input (required)
    * @return SftpInput
    * @throws BitmovinException if fails to make API call
    */
    public SftpInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * SFTP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return SftpInput
    * @throws BitmovinException if fails to make API call
    */
    public SftpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List SFTP Inputs
    * 
    * @return List&lt;SftpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SftpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List SFTP Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;SftpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<SftpInput> list(SftpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
