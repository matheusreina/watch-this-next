package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvResponse {
    private int page;
    private List<Tv> results;

    // Getters & Setters
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<Tv> getResults() {
        return results;
    }
    public void setResults(List<Tv> results) {
        this.results = results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Tv {
        private String id;
        private String name;
        private String overview;

        @JsonProperty("origin_country")
        private String[] originCountry;

        @JsonProperty("genre_ids")
        private String[] genreIds;

        @JsonProperty("poster_path")
        private String posterPath;

        @JsonProperty("backdrop_path")
        private String backdropPath;

        @JsonProperty("first_air_date")
        private String firstAirDate;

        @JsonProperty("vote_average")
        private String voteAverage;

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
        public String getOverview() {
            return overview;
        }
        public void setOverview(String overview) {
            this.overview = overview;
        }
        public String[] getOriginCountry() {
            return originCountry;
        }
        public void setOriginCountry(String[] originCountry) {
            this.originCountry = originCountry;
        }
        public String[] getGenreIds() {
            return genreIds;
        }
        public void setGenreIds(String[] genreIds) {
            this.genreIds = genreIds;
        }
        public String getPosterPath() {
            return posterPath;
        }
        public void setPosterPath(String posterPath) {
            this.posterPath = "https://image.tmdb.org/t/p/w500" + posterPath;
        }
        public String getBackdropPath() {
            return backdropPath;
        }
        public void setBackdropPath(String backdropPath) {
            this.backdropPath = "https://image.tmdb.org/t/p/w500" + backdropPath;
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
        public void setVoteAverage(String voteAverage) {
            this.voteAverage = voteAverage;
        }
    }
}
