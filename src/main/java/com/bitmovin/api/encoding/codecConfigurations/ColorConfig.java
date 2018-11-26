package com.bitmovin.api.encoding.codecConfigurations;

import com.bitmovin.api.encoding.codecConfigurations.enums.ChromaLocation;
import com.bitmovin.api.encoding.codecConfigurations.enums.ColorPrimaries;
import com.bitmovin.api.encoding.codecConfigurations.enums.ColorRange;
import com.bitmovin.api.encoding.codecConfigurations.enums.ColorSpace;
import com.bitmovin.api.encoding.codecConfigurations.enums.ColorTransfer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Roland Kersche on 27.09.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorConfig
{
    private Boolean copyChromaLocationFlag;
    private Boolean copyColorSpaceFlag;
    private Boolean copyColorPrimariesFlag;
    private Boolean copyColorRangeFlag;
    private Boolean copyColorTransferFlag;

    private ChromaLocation chromaLocation;
    private ColorSpace colorSpace;
    private ColorPrimaries colorPrimaries;
    private ColorRange colorRange;
    private ColorTransfer colorTransfer;

    private ColorSpace inputColorSpace;
    private ColorRange inputColorRange;

    public Boolean getCopyChromaLocationFlag()
    {
        return this.copyChromaLocationFlag;
    }
    public void setCopyChromaLocationFlag(Boolean copyChromaLocationFlag)
    {
        this.copyChromaLocationFlag = copyChromaLocationFlag;
    }
    public Boolean getCopyColorSpaceFlag()
    {
        return this.copyColorSpaceFlag;
    }
    public void setCopyColorSpaceFlag(Boolean copyColorSpaceFlag)
    {
        this.copyColorSpaceFlag = copyColorSpaceFlag;
    }
    public Boolean getCopyColorPrimariesFlag()
    {
        return this.copyColorPrimariesFlag;
    }
    public void setCopyColorPrimariesFlag(Boolean copyColorPrimariesFlag)
    {
        this.copyColorPrimariesFlag = copyColorPrimariesFlag;
    }
    public Boolean getCopyColorRangeFlag()
    {
        return this.copyColorRangeFlag;
    }
    public void setCopyColorRangeFlag(Boolean copyColorRangeFlag)
    {
        this.copyColorRangeFlag = copyColorRangeFlag;
    }
    public Boolean getCopyColorTransferFlag()
    {
        return this.copyColorTransferFlag;
    }
    public void setCopyColorTransferFlag(Boolean copyColorTransferFlag)
    {
        this.copyColorTransferFlag = copyColorTransferFlag;
    }
    public ChromaLocation getChromaLocation()
    {
        return this.chromaLocation;
    }
    public void setChromaLocation(ChromaLocation chromaLocation)
    {
        this.chromaLocation = chromaLocation;
    }
    public ColorSpace getColorSpace()
    {
        return this.colorSpace;
    }
    public void setColorSpace(ColorSpace colorSpace)
    {
        this.colorSpace = colorSpace;
    }
    public ColorPrimaries getColorPrimaries()
    {
        return this.colorPrimaries;
    }
    public void setColorPrimaries(ColorPrimaries colorPrimaries)
    {
        this.colorPrimaries = colorPrimaries;
    }
    public ColorRange getColorRange()
    {
        return this.colorRange;
    }
    public void setColorRange(ColorRange colorRange)
    {
        this.colorRange = colorRange;
    }
    public ColorTransfer getColorTransfer()
    {
        return this.colorTransfer;
    }
    public void setColorTransfer(ColorTransfer colorTransfer)
    {
        this.colorTransfer = colorTransfer;
    }

    public ColorSpace getInputColorSpace()
    {
        return this.inputColorSpace;
    }
    public void setInputColorSpace(ColorSpace inputColorSpace)
    {
        this.inputColorSpace = inputColorSpace;
    }
    public ColorRange getInputColorRange()
    {
        return this.inputColorRange;
    }
    public void setInputColorRange(ColorRange inputColorRange)
    {
        this.inputColorRange = inputColorRange;
    }
}
