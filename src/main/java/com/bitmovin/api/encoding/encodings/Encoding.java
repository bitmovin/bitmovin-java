package com.bitmovin.api.encoding.encodings;

import com.bitmovin.api.AbstractApiResponse;
import com.bitmovin.api.encoding.encodings.muxing.Muxing;
import com.bitmovin.api.encoding.enums.CloudRegion;
import com.bitmovin.api.encoding.encodings.streams.Stream;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * Ferdinand Koeppen [ferdinand.koeppen@bitmovin.com]
 * on 25.07.16.
 */
public class Encoding extends AbstractApiResponse
{
    private String name;
    private String description;

    private CloudRegion cloudRegion;

    private String encoderVersion;

    private String infrastructureId;

    private InfrastructureSettings infrastructure;

    @JsonIgnore
    private List<Stream> streams;
    @JsonIgnore
    private List<Muxing> muxings;
    private String userId;

    private String orgId;

    public Encoding() {
        this.streams = new ArrayList<>();
        this.muxings = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CloudRegion getCloudRegion() {
        return this.cloudRegion;
    }

    public void setCloudRegion(CloudRegion cloudRegion) {
        this.cloudRegion = cloudRegion;
    }

    public void addStream(Stream stream) {
        this.streams.add(stream);
    }

    public List<Stream> getStreams() {
        return this.streams;
    }

    public void setStreams(List<Stream> streams) {
        this.streams = streams;
    }

    public void addMuxing(Muxing muxing) {
        this.muxings.add(muxing);
    }

    public List<Muxing> getMuxings() {
        return this.muxings;
    }

    public void setMuxings(List<Muxing> muxings) {
        this.muxings = muxings;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getEncoderVersion()
    {
        return this.encoderVersion;
    }

    public void setEncoderVersion(String encoderVersion)
    {
        this.encoderVersion = encoderVersion;
    }

    public String getInfrastructureId()
    {
        return this.infrastructureId;
    }

    public void setInfrastructureId(String infrastructureId)
    {
        this.infrastructureId = infrastructureId;
    }

    public InfrastructureSettings getInfrastructure()
    {
        return this.infrastructure;
    }

    public void setInfrastructure(InfrastructureSettings infrastructure)
    {
        this.infrastructure = infrastructure;
    }
}
