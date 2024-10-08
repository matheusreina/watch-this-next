package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeGroupResponse {
    private String id;
    private List<EpisodeGroup> results;

    // G & S
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<EpisodeGroup> getResults() {
        return results;
    }
    public void setResults(List<EpisodeGroup> results) {
        this.results = results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EpisodeGroup {
        private String id;
        private String name;
        private String description;

        @JsonProperty("episode_count")
        private int episodeCount;

        // G & S
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public int getEpisodeCount() {
            return episodeCount;
        }
        public void setEpisodeCount(int episodeCount) {
            this.episodeCount = episodeCount;
        }
    }
}

