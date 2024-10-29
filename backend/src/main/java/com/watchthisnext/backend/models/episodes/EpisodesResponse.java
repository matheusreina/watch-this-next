package com.watchthisnext.backend.models.episodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodesResponse {
    private String id;
    private String name;
    private String overview;
    private int runtime;

    @JsonProperty("season_number")
    private int seasonNumber;

    @JsonProperty("episode_number")
    private int episodeNumber;

    @JsonProperty("air_date")
    private String airDate;

    @JsonProperty("still_path")
    private String stillPath;

    @JsonProperty("vote_average")
    private String voteAverage;

    @JsonProperty("show_id")
    private String showId;

    // G & S
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
    public int getRuntime() {
        return runtime;
    }
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
    public int getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
    public int getEpisodeNumber() {
        return episodeNumber;
    }
    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
    public String getAirDate() {
        return airDate;
    }
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }
    public String getStillPath() {
        return stillPath;
    }
    public void setStillPath(String stillPath) {
        this.stillPath = AppUtils.imageLinkFormatter(stillPath);
    }
    public String getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = AppUtils.voteAverageFormatter(voteAverage);
    }
    public String getShowId() {
        return showId;
    }
    public void setShowId(String showId) {
        this.showId = showId;
    }

}
