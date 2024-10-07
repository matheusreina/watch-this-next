package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailsResponse {
    private List<SelectedTv> result;

    // Getters & Setters
    public List<SelectedTv> getResult() {
        return result;
    }

    public void setResult(List<SelectedTv> result) {
        this.result = result;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SelectedTv {
        private String id;
        // For the name of the show, use the one from TvResponse
        private String status;
        private String overview;

        @JsonProperty("vote_average")
        private float voteAverage;

        @JsonProperty("first_air_date")
        private String firstAirDate;

        private String[] genres;

        @JsonProperty("number_of_episodes")
        private String numberOfEpisodes;

        @JsonProperty("number_of_seasons")
        private String numberOfSeasons;

        @JsonProperty("in_production")
        private String inProduction;

        @JsonProperty("next_episode_to_air")
        private String nextEpisodeToAir;

        private String[] seasons;

        @JsonProperty("production_countries")
        private String[] productionCountries;

        // Getters & Setters
    }
}
