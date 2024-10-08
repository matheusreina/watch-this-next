package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailsResponse {
    private String id;
    private String name;
    private String status;
    private String overview;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private float voteAverage;

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
    public float getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(float voteAverage) {
        this.voteAverage = (float) (Math.round(voteAverage * 10.0)/ 10.0);
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
}

