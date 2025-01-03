package com.watchthisnext.backend.models.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrendingResponse {
    private int page;
    private List<Media> results;

    // Getters & Setters
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<Media> getResults() {
        return results;
    }
    public void setResults(List<Media> results) {
        this.results = results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Media {
        private String id;
        private String name;
        private String title;
        private String date;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("first_air_date")
        private String firstAirDate;

        @JsonProperty("vote_average")
        private String voteAverage;

        @JsonProperty("poster_path")
        private String posterPath;

        @JsonProperty("media_type")
        private String mediaType;

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
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getDate() {
            return date;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public String getReleaseDate() {
            return releaseDate;
        }
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
        public String getFirstAirDate() {
            return firstAirDate;
        }
        public void setFirstAirDate(String firstAirDate) {
            this.firstAirDate = firstAirDate;
        }
        public String getVoteAverage() {
            return voteAverage;
        }
        public void setVoteAverage(double voteAverage) {
            this.voteAverage = AppUtils.voteAverageFormatter(voteAverage);
        }
        public String getPosterPath() {
            return posterPath;
        }
        public void setPosterPath(String posterPath) {
            this.posterPath = AppUtils.imageLinkFormatter(posterPath);;
        }
        public String getMediaType() {
            return mediaType;
        }
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }
    }
}
