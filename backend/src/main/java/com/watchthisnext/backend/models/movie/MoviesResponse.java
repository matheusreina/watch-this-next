package com.watchthisnext.backend.models.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesResponse {
    private int page;
    private List<Movie> results;

    // Getters & Setters
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<Movie> getResults() {
        return results;
    }
    public void setResults(List<Movie> results) {
        this.results = results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Movie {
        private String id;
        private String title;
        private String overview;

        @JsonProperty("media_type")
        private String mediaType;

        @JsonProperty("genre_ids")
        private String[] genreIds;

        @JsonProperty("poster_path")
        private String posterPath;

        @JsonProperty("backdrop_path")
        private String backdropPath;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("vote_average")
        private String voteAverage;

        // Getters & Setters
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getMediaType() {
            return mediaType;
        }
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }
        public String getOverview() {
            return overview;
        }
        public void setOverview(String overview) {
            this.overview = overview;
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
            this.posterPath = AppUtils.imageLinkFormatter(posterPath);
        }
        public String getBackdropPath() {
            return backdropPath;
        }
        public void setBackdropPath(String backdropPath) {
            this.backdropPath = AppUtils.imageLinkFormatter(backdropPath);
        }
        public String getReleaseDate() {
            return releaseDate;
        }
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
        public String getVoteAverage() {
            return voteAverage;
        }
        public void setVoteAverage(double voteAverage) {
            this.voteAverage = AppUtils.voteAverageFormatter(voteAverage);
        }
    }
}
