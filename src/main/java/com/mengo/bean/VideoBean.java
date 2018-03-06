package com.mengo.bean;

import java.util.List;

public class VideoBean {
    private String status;
    private List<VideoEpisode> episodeList;

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
