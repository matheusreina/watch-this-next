package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailsResponse {
    private String id;
    private String title;
    private String status;
    private String overview;
    private String runtime;

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private float voteAverage;

    @JsonProperty("release_date")
    private String releaseDate;

    private Object[] genres;

    @JsonProperty("number_of_episodes")
    private String numberOfEpisodes;

    @JsonProperty("number_of_seasons")
    private String numberOfSeasons;

    @JsonProperty("production_countries")
    private Object[] productionCountries;

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
    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
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
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
    public Object[] getProductionCountries() {
        return productionCountries;
    }
    public void setProductionCountries(Object[] productionCountries) {
        this.productionCountries = productionCountries;
    }
}
