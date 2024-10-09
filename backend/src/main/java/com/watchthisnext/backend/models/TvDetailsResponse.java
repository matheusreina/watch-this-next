package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailsResponse {
    private String id;
    private String name;
    private String status;
    private String overview;
    private Video videos;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("first_air_date")
    private String firstAirDate;

    private Object[] genres;

    @JsonProperty("number_of_episodes")
    private String numberOfEpisodes;

    @JsonProperty("number_of_seasons")
    private String numberOfSeasons;

    @JsonProperty("in_production")
    private String inProduction;

    @JsonProperty("next_episode_to_air")
    private String nextEpisodeToAir;

    private Object[] seasons;

    @JsonProperty("production_countries")
    private Object[] productionCountries;

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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public Video getVideos() {
        return videos;
    }
    public void setVideos(Video videos) {
        this.videos = videos;
    }
    public String getBackdropPath() {
        return backdropPath;
    }
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = "https://image.tmdb.org/t/p/w500" + backdropPath;
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = "https://image.tmdb.org/t/p/w500" + posterPath;
    }
    public double getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = (float) ((Math.round((voteAverage/2) * 10.0)/10.0));
    }
    public String getFirstAirDate() {
        return firstAirDate;
    }
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }
    public Object[] getGenres() {
        return genres;
    }
    public void setGenres(Object[] genres) {
        this.genres = genres;
    }
    public String getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    public void setNumberOfEpisodes(String numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    public String getNumberOfSeasons() {
        return numberOfSeasons;
    }
    public void setNumberOfSeasons(String numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }
    public String getInProduction() {
        return inProduction;
    }
    public void setInProduction(String inProduction) {
        this.inProduction = inProduction;
    }
    public String getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }
    public void setNextEpisodeToAir(String nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }
    public Object[] getSeasons() {
        return seasons;
    }
    public void setSeasons(Object[] seasons) {
        this.seasons = seasons;
    }
    public Object[] getProductionCountries() {
        return productionCountries;
    }
    public void setProductionCountries(Object[] productionCountries) {
        this.productionCountries = productionCountries;
    }

    public static class Video {
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

}

