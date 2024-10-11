package com.watchthisnext.backend.models.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideosResponse {
    private List<VideoResults> results;

    //G&S
    public List<VideoResults> getResults() {
        return results;
    }
    public void setResults(List<VideoResults> results) {
        this.results = results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class VideoResults {
        private String name;
        private String key;
        private String site;
        private String type;
        private boolean official;

        @JsonProperty("published_at")
        private String publishedAt;

        //G&S
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = "https://www.youtube.com/watch?v=" + key;
        }
        public String getSite() {
            return site;
        }
        public void setSite(String site) {
            this.site = site;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public boolean isOfficial() {
            return official;
        }
        public void setOfficial(boolean official) {
            this.official = official;
        }
        public String getPublishedAt() {
            return publishedAt;
        }
        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }
}

