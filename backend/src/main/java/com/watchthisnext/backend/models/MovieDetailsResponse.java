package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailsResponse {
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
}
