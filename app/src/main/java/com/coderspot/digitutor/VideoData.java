package com.coderspot.digitutor;

import android.net.Uri;
import android.os.Parcelable;

public class VideoData {

    private String video_name;
    private String channel_name;
    private String no_of_views;
    private String duration;
    private Uri uriString;
    private String uploaded_date;

    public VideoData(String video_name, String channel_name, String no_of_views, String duration, Uri uriString, String uploaded_date) {
        this.video_name = video_name;
        this.channel_name = channel_name;
        this.no_of_views = no_of_views;
        this.duration = duration;
        this.uriString = uriString;
        this.uploaded_date = uploaded_date;
    }

    public String getVideo_name() {
        return video_name;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public String getNo_of_views() {
        return no_of_views;
    }

    public String getDuration() {
        return duration;
    }

    public Uri getUriString() {
        return uriString;
    }

    public String getUploaded_date() {
        return uploaded_date;
    }
}
