package com.mengo.bean;

import java.util.List;

public class VideoBean {
    private String status;
    private String title;
    private String url;
    private List<VideoEpisode> episodeList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<VideoEpisode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<VideoEpisode> episodeList) {
        this.episodeList = episodeList;
    }

    public static class VideoEpisode {
        private String episode;
        private String videoLink;

        public String getEpisode() {
            return episode;
        }

        public void setEpisode(String episode) {
            this.episode = episode;
        }

        public String getVideoLink() {
            return videoLink;
        }

        public void setVideoLink(String videoLink) {
            this.videoLink = videoLink;
        }
    }
}
