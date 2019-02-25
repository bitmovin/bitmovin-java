package com.bitmovin.api.encoding.inputs.ftp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.inputs.ftp.customdata.CustomdataApi;

import com.bitmovin.api.model.*;

import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FtpApi
{
    private final FtpClient apiClient;
    public CustomdataApi customdata;

    public FtpApi(String bitmovinApiKey)
    {
        this(bitmovinApiKey, null);
    }

    public FtpApi(String bitmovinApiKey, String tenantOrgId)
    {
        this(new BitmovinApiClientFactoryImpl(bitmovinApiKey, tenantOrgId));
    }

    public FtpApi(BitmovinApiClientFactory clientFactory)
    {
        if (clientFactory == null)
        {
            throw new IllegalArgumentException("Parameter 'clientFactory' may not be null.");
        }

        this.apiClient = clientFactory.createApiClient(FtpClient.class);

        customdata = new CustomdataApi(clientFactory);
    }


    /**
    * Create FTP Input
    * 
    * @param ftpInput The FTP input to be created (optional)
    * @return FtpInput
    * @throws BitmovinException if fails to make API call
    */
    public FtpInput create(FtpInput ftpInput) throws BitmovinException
    {
        return this.apiClient.create(ftpInput);
    }

    /**
    * Delete FTP Input
    * 
    * @param inputId Id of the input (required)
    * @return FtpInput
    * @throws BitmovinException if fails to make API call
    */
    public FtpInput delete(String inputId) throws BitmovinException
    {
        return this.apiClient.delete(inputId);
    }

    /**
    * FTP Input Details
    * 
    * @param inputId Id of the input (required)
    * @return FtpInput
    * @throws BitmovinException if fails to make API call
    */
    public FtpInput get(String inputId) throws BitmovinException
    {
        return this.apiClient.get(inputId);
    }
    /**
    * List FTP Inputs
    * 
    * @return List&lt;FtpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FtpInput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List FTP Inputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;FtpInput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FtpInput> list(FtpInputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
