package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.drms.*;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.exceptions.BitmovinApiException;
import com.bitmovin.api.http.RestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * Created by rkersche on 9/5/16.
 */
public class EncodingDrmResource
{

    private Map<String, String> headers;

    public EncodingDrmResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public WidevineDrm getWidevineDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.widevineDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, WidevineDrm.class);
    }

    public PlayReadyDrm getPlayReadyDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.playReadyDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, PlayReadyDrm.class);
    }

    public ClearKeyDrm getClearKeyDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.clearKeyDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, ClearKeyDrm.class);
    }

    public AesEncryptionDrm getAesEncryptionDrm(Encoding encoding, TSMuxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.aesEncryptionDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, AesEncryptionDrm.class);
    }

    public CencDrm getCencDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.cencDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, CencDrm.class);
    }

    public FairPlayDrm getFmp4FairPlayDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.fairPlayFmp4Drms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, FairPlayDrm.class);
    }

    public FairPlayDrm getTsFairPlayDrm(Encoding encoding, TSMuxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.fairPlayTsDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, FairPlayDrm.class);
    }

    public MarlinDrm getMarlinDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.marlinDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, MarlinDrm.class);
    }

    public PrimeTimeDrm getPrimeTimeDrm(Encoding encoding, FMP4Muxing muxing, String drmId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.primeTimeDrms.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        newUrl += "/" + drmId;
        return RestClient.get(newUrl, this.headers, PrimeTimeDrm.class);
    }

    public List<TypeDrm> listFmp4Drms(Encoding encoding, FMP4Muxing muxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.allDrmsFromFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        return RestClient.getItems(newUrl, this.headers, TypeDrm.class);
    }

    public List<TypeDrm> listTsDrms(Encoding encoding, TSMuxing muxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.allDrmsFromTsMuxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        return RestClient.getItems(newUrl, this.headers, TypeDrm.class);
    }

    public List<TypeDrm> listMp4Drms(Encoding encoding, MP4Muxing muxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.allDrmsFromMp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", muxing.getId());
        return RestClient.getItems(newUrl, this.headers, TypeDrm.class);
    }
}
