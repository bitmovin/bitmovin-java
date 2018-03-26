package com.bitmovin.api.encoding.filters;

import com.bitmovin.api.encoding.filters.enums.TextFilterFont;

public class TextFilter extends Filter
{
    private TextFilterFont font;
    private Boolean box;
    private Integer boxBorderWidth;
    private String boxColor;
    private Integer lineSpacing;
    private Integer borderWidth;
    private Boolean fixBounds;
    private String fontColor;
    private Integer fontSize;
    private Integer alpha;
    private String shadowColor;
    private Integer shadowX;
    private Integer shadowY;
    private String timecode;
    private String text;
    private String x;
    private String y;

    public TextFilterFont getFont()
    {
        return font;
    }

    public void setFont(TextFilterFont font)
    {
        this.font = font;
    }

    public Boolean getBox()
    {
        return box;
    }

    public void setBox(Boolean box)
    {
        this.box = box;
    }

    public Integer getBoxBorderWidth()
    {
        return boxBorderWidth;
    }

    public void setBoxBorderWidth(Integer boxBorderWidth)
    {
        this.boxBorderWidth = boxBorderWidth;
    }

    public String getBoxColor()
    {
        return boxColor;
    }

    public void setBoxColor(String boxColor)
    {
        this.boxColor = boxColor;
    }

    public Integer getLineSpacing()
    {
        return lineSpacing;
    }

    public void setLineSpacing(Integer lineSpacing)
    {
        this.lineSpacing = lineSpacing;
    }

    public Integer getBorderWidth()
    {
        return borderWidth;
    }

    public void setBorderWidth(Integer borderWidth)
    {
        this.borderWidth = borderWidth;
    }

    public Boolean getFixBounds()
    {
        return fixBounds;
    }

    public void setFixBounds(Boolean fixBounds)
    {
        this.fixBounds = fixBounds;
    }

    public String getFontColor()
    {
        return fontColor;
    }

    public void setFontColor(String fontColor)
    {
        this.fontColor = fontColor;
    }

    public Integer getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
    }

    public Integer getAlpha()
    {
        return alpha;
    }

    public void setAlpha(Integer alpha)
    {
        this.alpha = alpha;
    }

    public String getShadowColor()
    {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor)
    {
        this.shadowColor = shadowColor;
    }

    public Integer getShadowX()
    {
        return shadowX;
    }

    public void setShadowX(Integer shadowX)
    {
        this.shadowX = shadowX;
    }

    public Integer getShadowY()
    {
        return shadowY;
    }

    public void setShadowY(Integer shadowY)
    {
        this.shadowY = shadowY;
    }

    public String getTimecode()
    {
        return timecode;
    }

    public void setTimecode(String timecode)
    {
        this.timecode = timecode;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getX()
    {
        return x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    public String getY()
    {
        return y;
    }

    public void setY(String y)
    {
        this.y = y;
    }
}
