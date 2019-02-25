package com.bitmovin.api.encoding.outputs.ftp;

import com.bitmovin.api.common.BitmovinApiClientFactory;
import com.bitmovin.api.common.BitmovinException;
import com.bitmovin.api.common.BitmovinApiClientFactoryImpl;

import com.bitmovin.api.encoding.outputs.ftp.customdata.CustomdataApi;

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
    * Create FTP Output
    * 
    * @param ftpOutput The FTP output to be created (optional)
    * @return FtpOutput
    * @throws BitmovinException if fails to make API call
    */
    public FtpOutput create(FtpOutput ftpOutput) throws BitmovinException
    {
        return this.apiClient.create(ftpOutput);
    }

    /**
    * Delete FTP Output
    * 
    * @param outputId Id of the output (required)
    * @return FtpOutput
    * @throws BitmovinException if fails to make API call
    */
    public FtpOutput delete(String outputId) throws BitmovinException
    {
        return this.apiClient.delete(outputId);
    }

    /**
    * FTP Output Details
    * 
    * @param outputId Id of the output (required)
    * @return FtpOutput
    * @throws BitmovinException if fails to make API call
    */
    public FtpOutput get(String outputId) throws BitmovinException
    {
        return this.apiClient.get(outputId);
    }
    /**
    * List FTP Outputs
    * 
    * @return List&lt;FtpOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FtpOutput> list() throws BitmovinException
    {
        return this.apiClient.list(new HashMap<String, Object>());
    }

    /**
    * List FTP Outputs
    * 
    * @param queryParams The query parameters for sorting, filtering and paging options (optional)
    * @return List&lt;FtpOutput&gt;
    * @throws BitmovinException if fails to make API call
    */
    public List<FtpOutput> list(FtpOutputsListQueryParams queryParams) throws BitmovinException
    {
        return this.apiClient.list(queryParams);
    }
}
