package com.watchthisnext.backend.models.episodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.AppUtils;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonsResponse {
    private String id;
    private String name;
    private String overview;

    @JsonProperty("season_number")
    private int seasonNumber;

    @JsonProperty("air_date")
    private String airDate;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("poster_path")
    private String posterPath;
    private List<EpisodesResponse> episodes;

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
    public int getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
    public String getAirDate() {
        return airDate;
    }
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }
    public double getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = AppUtils.voteAverageFormatter(voteAverage);
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = AppUtils.imageLinkFormatter(posterPath);
    }
    public List<EpisodesResponse> getEpisodes() {
        return episodes;
    }
    public void setEpisodes(List<EpisodesResponse> episodes) {
        this.episodes = episodes;
    }
}

