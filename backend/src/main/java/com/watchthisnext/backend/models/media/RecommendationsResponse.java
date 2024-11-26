package com.watchthisnext.backend.models.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendationsResponse {
    private int page;
    private List<Recommendations> results;

    // Getters and Setters
    public List<Recommendations> getResults() {
        return results;
    }
    public void setResults(List<Recommendations> results) {
        this.results = results;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Recommendations{
        private String id;
        private String name;
        private int popularity;

        @JsonProperty("media_type")
        private String mediaType;

        @JsonProperty("poster_path")
        private String poster;

        @JsonProperty("first_air_date")
        private String date;
        private String releasedYear;


        // Getters & Setters
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
        public int getPopularity() {
            return popularity;
        }
        public void setPopularity(int popularity) {
            this.popularity = popularity;
        }
        public String getMediaType() {
            return mediaType;
        }
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }
        public String getPoster() {
            return poster;
        }
        public void setPoster(String poster) {
            this.poster = AppUtils.imageLinkFormatter(poster);
        }
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public String getReleasedYear() {
            return releasedYear;
        }
        public void setReleasedYear(String releasedYear) {
        this.releasedYear = AppUtils.getReleaseYear(this.getDate());
    }
    }
}
