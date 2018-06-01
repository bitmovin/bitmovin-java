package com.bitmovin.api.resource.encoding;

import com.bitmovin.api.RestClient;
import com.bitmovin.api.constants.ApiUrls;
import com.bitmovin.api.customData.CustomData;
import com.bitmovin.api.encoding.encodings.Encoding;
import com.bitmovin.api.encoding.encodings.drms.AesEncryptionDrm;
import com.bitmovin.api.encoding.encodings.drms.CencDrm;
import com.bitmovin.api.encoding.encodings.drms.ClearKeyDrm;
import com.bitmovin.api.encoding.encodings.drms.FairPlayDrm;
import com.bitmovin.api.encoding.encodings.drms.MarlinDrm;
import com.bitmovin.api.encoding.encodings.drms.PlayReadyDrm;
import com.bitmovin.api.encoding.encodings.drms.PrimeTimeDrm;
import com.bitmovin.api.encoding.encodings.drms.WidevineDrm;
import com.bitmovin.api.encoding.encodings.muxing.FMP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.MP4Muxing;
import com.bitmovin.api.encoding.encodings.muxing.ProgressiveMOVMuxing;
import com.bitmovin.api.encoding.encodings.muxing.ProgressiveTSMuxing;
import com.bitmovin.api.encoding.encodings.muxing.TSMuxing;
import com.bitmovin.api.encoding.encodings.muxing.WebmMuxing;
import com.bitmovin.api.encoding.encodings.muxing.broadcastTs.BroadcastTsMuxing;
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
public class EncodingMuxingResource
{

    private Map<String, String> headers;

    public EncodingMuxingResource(Map<String, String> headers)
    {
        this.headers = headers;
    }

    public FMP4Muxing getFMP4Muxing(Encoding encoding, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getFMP4Muxing(encoding.getId(), muxingId);
    }

    public FMP4Muxing getFMP4Muxing(String encodingId, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.fmp4muxings.replace("{encoding_id}", encodingId) + "/" + muxingId;
        return RestClient.get(newUrl, this.headers, FMP4Muxing.class);
    }

    public WebmMuxing getWebmMuxing(Encoding encoding, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getWebmMuxing(encoding.getId(), muxingId);
    }

    public WebmMuxing getWebmMuxing(String encodingId, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.webmmuxings.replace("{encoding_id}", encodingId) + "/" + muxingId;
        return RestClient.get(newUrl, this.headers, WebmMuxing.class);
    }

    public CustomData getFMP4MuxingCustomData(String encodingId, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.fmp4muxings.replace("{encoding_id}", encodingId) + "/" + muxingId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public CustomData getProgressiveTSMuxingCustomData(String encodingId, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.progressivetsmuxings.replace("{encoding_id}", encodingId) + "/" + muxingId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }

    public TSMuxing getTSMuxing(Encoding encoding, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        return this.getTSMuxing(encoding.getId(), muxingId);
    }

    public TSMuxing getTSMuxing(String encodingId, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.tsmuxings.replace("{encoding_id}", encodingId) + "/" + muxingId;
        return RestClient.get(newUrl, this.headers, TSMuxing.class);
    }

    public CustomData getTsMuxingCustomData(String encodingId, String muxingId) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.tsmuxings.replace("{encoding_id}", encodingId) + "/" + muxingId + ApiUrls.customDataSuffix;
        return RestClient.get(newUrl, this.headers, CustomData.class);
    }


    public List<String> getFMP4MuxingIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.fmp4muxings.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public List<String> getTSMuxingIds(Encoding encoding) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.tsmuxings.replace("{encoding_id}", encoding.getId());
        return RestClient.getListOfIds(newUrl, this.headers);
    }

    public FMP4Muxing addFmp4MuxingToEncoding(Encoding encoding, FMP4Muxing fmp4Muxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.fmp4muxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, fmp4Muxing, FMP4Muxing.class);
    }

    public ProgressiveTSMuxing addProgressiveTSMuxingToEncoding(Encoding encoding, ProgressiveTSMuxing progressiveTSMuxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.progressivetsmuxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, progressiveTSMuxing, ProgressiveTSMuxing.class);
    }

    public WebmMuxing addWebmMuxingToEncoding(Encoding encoding, WebmMuxing webmMuxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.webmmuxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, webmMuxing, WebmMuxing.class);
    }

    public TSMuxing addTSMuxingToEncoding(Encoding encoding, TSMuxing tsMuxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.tsmuxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, tsMuxing, TSMuxing.class);
    }

    public MP4Muxing addMp4MuxingToEncoding(Encoding encoding, MP4Muxing mp4Muxing) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.mp4muxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, mp4Muxing, MP4Muxing.class);
    }

    public CencDrm addCencDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, CencDrm cencDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addCencDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, cencDrm, CencDrm.class);
    }

    public WidevineDrm addWidevineDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, WidevineDrm widevineDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addWidevineDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, widevineDrm, WidevineDrm.class);
    }

    public PlayReadyDrm addPlayReadyDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, PlayReadyDrm playReadyDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addPlayReadyDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, playReadyDrm, PlayReadyDrm.class);
    }

    public PlayReadyDrm addPlayReadyDrmToMP4Muxing(Encoding encoding, MP4Muxing mp4Muxing, PlayReadyDrm playReadyDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addPlayReadyDrmToMP4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", mp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, playReadyDrm, PlayReadyDrm.class);
    }

    public ClearKeyDrm addClearKeyDrmToMP4Muxing(Encoding encoding, MP4Muxing mp4Muxing, ClearKeyDrm clearKeyDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addClearKeyDrmToMP4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", mp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, clearKeyDrm, ClearKeyDrm.class);
    }

    public PrimeTimeDrm addPrimeTimeDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, PrimeTimeDrm primeTimeDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addPrimeTimeDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, primeTimeDrm, PrimeTimeDrm.class);
    }

    public FairPlayDrm addFairPlayDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, FairPlayDrm fairPlayDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addFairPlayDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, fairPlayDrm, FairPlayDrm.class);
    }

    public MarlinDrm addMarlinDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, MarlinDrm marlinDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addMarlinDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, marlinDrm, MarlinDrm.class);
    }

    public ClearKeyDrm addClearKeyDrmToFmp4Muxing(Encoding encoding, FMP4Muxing fmp4Muxing, ClearKeyDrm clearKeyDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addClearKeyDrmToFmp4Muxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", fmp4Muxing.getId());
        return RestClient.post(this.headers, newUrl, clearKeyDrm, ClearKeyDrm.class);
    }

    public FairPlayDrm addFairPlayDrmToTssMuxing(Encoding encoding, TSMuxing tsMuxing, FairPlayDrm fairPlayDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addFairPlayDrmToTssMuxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", tsMuxing.getId());
        return RestClient.post(this.headers, newUrl, fairPlayDrm, FairPlayDrm.class);
    }

    public AesEncryptionDrm addAESEncryptionToTssMuxing(Encoding encoding, TSMuxing tsMuxing, AesEncryptionDrm aesEncryptionDrm) throws BitmovinApiException, IOException, RestException, URISyntaxException, UnirestException
    {
        String newUrl = ApiUrls.addAESEncryptionToTssMuxing.replace("{encoding_id}", encoding.getId());
        newUrl = newUrl.replace("{muxing_id}", tsMuxing.getId());
        return RestClient.post(this.headers, newUrl, aesEncryptionDrm, AesEncryptionDrm.class);
    }

    public ProgressiveMOVMuxing addProgressiveMOVMuxingToEncoding(Encoding encoding, ProgressiveMOVMuxing progressiveMOVMuxing) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String newUrl = ApiUrls.progressiveMovMuxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, progressiveMOVMuxing);
    }

    public BroadcastTsMuxing addBroadcastTsMuxingToEncoding(Encoding encoding, BroadcastTsMuxing muxing) throws BitmovinApiException, UnirestException, IOException, URISyntaxException
    {
        String newUrl = ApiUrls.broadcastTsMuxings.replace("{encoding_id}", encoding.getId());
        return RestClient.post(this.headers, newUrl, muxing);
    }
}
