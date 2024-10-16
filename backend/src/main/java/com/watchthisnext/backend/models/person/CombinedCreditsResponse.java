package com.watchthisnext.backend.models.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.AppUtils;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CombinedCreditsResponse {
    private List<CastCredit> cast;
    private List<CrewCredit> crew;

    // Getters & Setters
    public List<CastCredit> getCast() {
        return cast;
    }
    public void setCast(List<CastCredit> cast) {
        this.cast = cast;
    }
    public List<CrewCredit> getCrew() {
        return crew;
    }
    public void setCrew(List<CrewCredit> crew) {
        this.crew = crew;
    }

    public static class CastCredit {
        private String title;
        private String character;

        @JsonProperty("episode_count")
        private String episodeCount;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("first_air_date")
        private String firstAirDate;

        @JsonProperty("vote_average")
        private double voteAverage;
        private double popularity;

        @JsonProperty("credit_id")
        private String creditId;

        @JsonProperty("id")
        private String mediaId;

        @JsonProperty("media_type")
        private String mediaType;

        @JsonProperty("poster_path")
        private String posterPath;

        // Getters & Setters
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getCharacter() {
            return character;
        }
        public void setCharacter(String character) {
            this.character = character;
        }
        public String getEpisodeCount() {
            return episodeCount;
        }
        public void setEpisodeCount(String episodeCount) {
            this.episodeCount = episodeCount;
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
        public double getVoteAverage() {
            return voteAverage;
        }
        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }
        public double getPopularity() {
            return popularity;
        }
        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }
        public String getCreditId() {
            return creditId;
        }
        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }
        public String getMediaId() {
            return mediaId;
        }
        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
        public String getMediaType() {
            return mediaType;
        }
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }
        public String getPosterPath() {
            return posterPath;
        }
        public void setPosterPath(String posterPath) {
            this.posterPath = AppUtils.imageLinkFormatter(posterPath);
        }
    }

    public static class CrewCredit {
        private String name;
        private String department;
        private String job;

        @JsonProperty("episode_count")
        private String episodeCount;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("first_air_date")
        private String firstAirDate;

        @JsonProperty("vote_average")
        private double voteAverage;
        private double popularity;

        @JsonProperty("credit_id")
        private String creditId;

        @JsonProperty("id")
        private String mediaId;

        @JsonProperty("media_type")
        private String mediaType;

        @JsonProperty("poster_path")
        private String posterPath;

        // Getters & Setters
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public String getJob() {
            return job;
        }
        public void setJob(String job) {
            this.job = job;
        }
        public String getEpisodeCount() {
            return episodeCount;
        }
        public void setEpisodeCount(String episodeCount) {
            this.episodeCount = episodeCount;
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
        public double getVoteAverage() {
            return voteAverage;
        }
        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }
        public double getPopularity() {
            return popularity;
        }
        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }
        public String getCreditId() {
            return creditId;
        }
        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }
        public String getMediaId() {
            return mediaId;
        }
        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
        public String getMediaType() {
            return mediaType;
        }
        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }
        public String getPosterPath() {
            return posterPath;
        }
        public void setPosterPath(String posterPath) {
            this.posterPath = AppUtils.imageLinkFormatter(posterPath);
        }
    }
}
