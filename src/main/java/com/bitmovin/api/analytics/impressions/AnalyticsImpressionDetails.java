package com.bitmovin.api.analytics.impressions;

import com.bitmovin.api.AbstractApiResponse;

public class AnalyticsImpressionDetails extends AbstractApiResponse
{
    private Long        ad;
    private String      analyticsVersion;
    private String      apiOrgId;
    private String      apiUserId;
    private Long        audioBitRate;
    private Boolean     autoplay;
    private String      browser;
    private String      browserVersionMajor;
    private String      browserVersionMinor;
    private Boolean     buffered;
    private String      cdnProvider;
    private String      city;
    private Long        clientTime;
    private String      country;
    private String      customUserId;
    private String      customData1;
    private String      customData2;
    private String      customData3;
    private String      customData4;
    private String      customData5;
    private Long        day;
    private String      deviceType;
    private String      dmain;
    private Long        droppedFrames;
    private Long        duration;
    private Integer     errorCode;
    private String      errorMessage;
    private String      experimentName;
    private Long        hour;
    private String      impressionId;
    private String      ipAddress;
    private Boolean     isCasting;
    private Boolean     isLive;
    private Boolean     isMuted;
    private String      language;
    private Long        minute;
    private Long        month;
    private String      licenseKey;
    private String      operatingSystem;
    private String      operatingSystemVersionMajor;
    private String      operatingSystemVersionMinor;
    private Integer     pageLoadTime;
    private Integer     pageLoadType;
    private String      path;
    private Long        paused;
    private Long        played;
    private String      player;
    private String      playerKey;
    private Integer     playerStartuptime;
    private String      playerTech;
    private String      playerVersion;
    private String      region;
    private Integer     screenHeight;
    private Integer     screenWidth;
    private Long        seeked;
    private String      size;
    private Integer     startupTime;
    private String      state;
    private String      streamFormat;
    private Long        time;
    private String      userId;
    private Long        videoBitrate;
    private Long        videoDuration;
    private String      videoId;
    private Integer     videoPlaybackHeight;
    private Integer     videoPlaybackWidth;
    private Long        videoStartupTime;
    private Long        videoTimeEnd;
    private Long        videoTimeStart;
    private Integer     videoWindowHeight;
    private Integer     videoWindowWidth;
    private Long        year;

    public Long getAd()
    {
        return ad;
    }

    public void setAd(Long ad)
    {
        this.ad = ad;
    }

    public String getAnalyticsVersion()
    {
        return analyticsVersion;
    }

    public void setAnalyticsVersion(String analyticsVersion)
    {
        this.analyticsVersion = analyticsVersion;
    }

    public String getApiOrgId()
    {
        return apiOrgId;
    }

    public void setApiOrgId(String apiOrgId)
    {
        this.apiOrgId = apiOrgId;
    }

    public String getApiUserId()
    {
        return apiUserId;
    }

    public void setApiUserId(String apiUserId)
    {
        this.apiUserId = apiUserId;
    }

    public Long getAudioBitRate()
    {
        return audioBitRate;
    }

    public void setAudioBitRate(Long audioBitRate)
    {
        this.audioBitRate = audioBitRate;
    }

    public Boolean getAutoplay()
    {
        return autoplay;
    }

    public void setAutoplay(Boolean autoplay)
    {
        this.autoplay = autoplay;
    }

    public String getBrowser()
    {
        return browser;
    }

    public void setBrowser(String browser)
    {
        this.browser = browser;
    }

    public String getBrowserVersionMajor()
    {
        return browserVersionMajor;
    }

    public void setBrowserVersionMajor(String browserVersionMajor)
    {
        this.browserVersionMajor = browserVersionMajor;
    }

    public String getBrowserVersionMinor()
    {
        return browserVersionMinor;
    }

    public void setBrowserVersionMinor(String browserVersionMinor)
    {
        this.browserVersionMinor = browserVersionMinor;
    }

    public Boolean getBuffered()
    {
        return buffered;
    }

    public void setBuffered(Boolean buffered)
    {
        this.buffered = buffered;
    }

    public String getCdnProvider()
    {
        return cdnProvider;
    }

    public void setCdnProvider(String cdnProvider)
    {
        this.cdnProvider = cdnProvider;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public Long getClientTime()
    {
        return clientTime;
    }

    public void setClientTime(Long clientTime)
    {
        this.clientTime = clientTime;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCustomUserId()
    {
        return customUserId;
    }

    public void setCustomUserId(String customUserId)
    {
        this.customUserId = customUserId;
    }

    public String getCustomData1()
    {
        return customData1;
    }

    public void setCustomData1(String customData1)
    {
        this.customData1 = customData1;
    }

    public String getCustomData2()
    {
        return customData2;
    }

    public void setCustomData2(String customData2)
    {
        this.customData2 = customData2;
    }

    public String getCustomData3()
    {
        return customData3;
    }

    public void setCustomData3(String customData3)
    {
        this.customData3 = customData3;
    }

    public String getCustomData4()
    {
        return customData4;
    }

    public void setCustomData4(String customData4)
    {
        this.customData4 = customData4;
    }

    public String getCustomData5()
    {
        return customData5;
    }

    public void setCustomData5(String customData5)
    {
        this.customData5 = customData5;
    }

    public Long getDay()
    {
        return day;
    }

    public void setDay(Long day)
    {
        this.day = day;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDmain()
    {
        return dmain;
    }

    public void setDmain(String dmain)
    {
        this.dmain = dmain;
    }

    public Long getDroppedFrames()
    {
        return droppedFrames;
    }

    public void setDroppedFrames(Long droppedFrames)
    {
        this.droppedFrames = droppedFrames;
    }

    public Long getDuration()
    {
        return duration;
    }

    public void setDuration(Long duration)
    {
        this.duration = duration;
    }

    public Integer getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getExperimentName()
    {
        return experimentName;
    }

    public void setExperimentName(String experimentName)
    {
        this.experimentName = experimentName;
    }

    public Long getHour()
    {
        return hour;
    }

    public void setHour(Long hour)
    {
        this.hour = hour;
    }

    public String getImpressionId()
    {
        return impressionId;
    }

    public void setImpressionId(String impressionId)
    {
        this.impressionId = impressionId;
    }

    public String getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress)
    {
        this.ipAddress = ipAddress;
    }

    public Boolean getCasting()
    {
        return isCasting;
    }

    public void setCasting(Boolean casting)
    {
        isCasting = casting;
    }

    public Boolean getLive()
    {
        return isLive;
    }

    public void setLive(Boolean live)
    {
        isLive = live;
    }

    public Boolean getMuted()
    {
        return isMuted;
    }

    public void setMuted(Boolean muted)
    {
        isMuted = muted;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Long getMinute()
    {
        return minute;
    }

    public void setMinute(Long minute)
    {
        this.minute = minute;
    }

    public Long getMonth()
    {
        return month;
    }

    public void setMonth(Long month)
    {
        this.month = month;
    }

    public String getLicenseKey()
    {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey)
    {
        this.licenseKey = licenseKey;
    }

    public String getOperatingSystem()
    {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystemVersionMajor()
    {
        return operatingSystemVersionMajor;
    }

    public void setOperatingSystemVersionMajor(String operatingSystemVersionMajor)
    {
        this.operatingSystemVersionMajor = operatingSystemVersionMajor;
    }

    public String getOperatingSystemVersionMinor()
    {
        return operatingSystemVersionMinor;
    }

    public void setOperatingSystemVersionMinor(String operatingSystemVersionMinor)
    {
        this.operatingSystemVersionMinor = operatingSystemVersionMinor;
    }

    public Integer getPageLoadTime()
    {
        return pageLoadTime;
    }

    public void setPageLoadTime(Integer pageLoadTime)
    {
        this.pageLoadTime = pageLoadTime;
    }

    public Integer getPageLoadType()
    {
        return pageLoadType;
    }

    public void setPageLoadType(Integer pageLoadType)
    {
        this.pageLoadType = pageLoadType;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public Long getPaused()
    {
        return paused;
    }

    public void setPaused(Long paused)
    {
        this.paused = paused;
    }

    public Long getPlayed()
    {
        return played;
    }

    public void setPlayed(Long played)
    {
        this.played = played;
    }

    public String getPlayer()
    {
        return player;
    }

    public void setPlayer(String player)
    {
        this.player = player;
    }

    public String getPlayerKey()
    {
        return playerKey;
    }

    public void setPlayerKey(String playerKey)
    {
        this.playerKey = playerKey;
    }

    public Integer getPlayerStartuptime()
    {
        return playerStartuptime;
    }

    public void setPlayerStartuptime(Integer playerStartuptime)
    {
        this.playerStartuptime = playerStartuptime;
    }

    public String getPlayerTech()
    {
        return playerTech;
    }

    public void setPlayerTech(String playerTech)
    {
        this.playerTech = playerTech;
    }

    public String getPlayerVersion()
    {
        return playerVersion;
    }

    public void setPlayerVersion(String playerVersion)
    {
        this.playerVersion = playerVersion;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public Integer getScreenHeight()
    {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight)
    {
        this.screenHeight = screenHeight;
    }

    public Integer getScreenWidth()
    {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth)
    {
        this.screenWidth = screenWidth;
    }

    public Long getSeeked()
    {
        return seeked;
    }

    public void setSeeked(Long seeked)
    {
        this.seeked = seeked;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public Integer getStartupTime()
    {
        return startupTime;
    }

    public void setStartupTime(Integer startupTime)
    {
        this.startupTime = startupTime;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getStreamFormat()
    {
        return streamFormat;
    }

    public void setStreamFormat(String streamFormat)
    {
        this.streamFormat = streamFormat;
    }

    public Long getTime()
    {
        return time;
    }

    public void setTime(Long time)
    {
        this.time = time;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Long getVideoBitrate()
    {
        return videoBitrate;
    }

    public void setVideoBitrate(Long videoBitrate)
    {
        this.videoBitrate = videoBitrate;
    }

    public Long getVideoDuration()
    {
        return videoDuration;
    }

    public void setVideoDuration(Long videoDuration)
    {
        this.videoDuration = videoDuration;
    }

    public String getVideoId()
    {
        return videoId;
    }

    public void setVideoId(String videoId)
    {
        this.videoId = videoId;
    }

    public Integer getVideoPlaybackHeight()
    {
        return videoPlaybackHeight;
    }

    public void setVideoPlaybackHeight(Integer videoPlaybackHeight)
    {
        this.videoPlaybackHeight = videoPlaybackHeight;
    }

    public Integer getVideoPlaybackWidth()
    {
        return videoPlaybackWidth;
    }

    public void setVideoPlaybackWidth(Integer videoPlaybackWidth)
    {
        this.videoPlaybackWidth = videoPlaybackWidth;
    }

    public Long getVideoStartupTime()
    {
        return videoStartupTime;
    }

    public void setVideoStartupTime(Long videoStartupTime)
    {
        this.videoStartupTime = videoStartupTime;
    }

    public Long getVideoTimeEnd()
    {
        return videoTimeEnd;
    }

    public void setVideoTimeEnd(Long videoTimeEnd)
    {
        this.videoTimeEnd = videoTimeEnd;
    }

    public Long getVideoTimeStart()
    {
        return videoTimeStart;
    }

    public void setVideoTimeStart(Long videoTimeStart)
    {
        this.videoTimeStart = videoTimeStart;
    }

    public Integer getVideoWindowHeight()
    {
        return videoWindowHeight;
    }

    public void setVideoWindowHeight(Integer videoWindowHeight)
    {
        this.videoWindowHeight = videoWindowHeight;
    }

    public Integer getVideoWindowWidth()
    {
        return videoWindowWidth;
    }

    public void setVideoWindowWidth(Integer videoWindowWidth)
    {
        this.videoWindowWidth = videoWindowWidth;
    }

    public Long getYear()
    {
        return year;
    }

    public void setYear(Long year)
    {
        this.year = year;
    }
}
