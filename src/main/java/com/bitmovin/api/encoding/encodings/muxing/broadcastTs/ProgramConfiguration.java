package com.bitmovin.api.encoding.encodings.muxing.broadcastTs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProgramConfiguration
{
    private Integer programNumber;

    private Integer pidForPMT;

    private Boolean insertProgramClockRefOnPes;

    public ProgramConfiguration()
    {

    }

    public Integer getProgramNumber()
    {
        return this.programNumber;
    }

    public void setProgramNumber(Integer programNumber)
    {
        this.programNumber = programNumber;
    }

    public Integer getPidForPMT()
    {
        return this.pidForPMT;
    }

    public void setPidForPMT(Integer pidForPMT)
    {
        this.pidForPMT = pidForPMT;
    }

    public Boolean getInsertProgramClockRefOnPes()
    {
        return this.insertProgramClockRefOnPes;
    }

    public void setInsertProgramClockRefOnPes(Boolean insertProgramClockRefOnPes)
    {
        this.insertProgramClockRefOnPes = insertProgramClockRefOnPes;
    }
}
