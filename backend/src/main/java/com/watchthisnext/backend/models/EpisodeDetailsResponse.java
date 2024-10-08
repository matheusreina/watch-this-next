package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EpisodeDetailsResponse {
    private List<Group> groups;

    //G & S
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public static class Group {
        private List<Episodes> episodes;

        // G & S
        public List<Episodes> getEpisodes() {
            return episodes;
        }
        public void setEpisodes(List<Episodes> episodes) {
            this.episodes = episodes;
        }

        public static class Episodes {
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
            private double voteAverage;

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
                this.stillPath = "https://image.tmdb.org/t/p/w500" + stillPath;
            }
            public double getVoteAverage() {
                return voteAverage;
            }
            public void setVoteAverage(double voteAverage) {
                this.voteAverage = ((Math.round((voteAverage/2) * 10.0)/10.0));
            }
            public String getShowId() {
                return showId;
            }
            public void setShowId(String showId) {
                this.showId = showId;
            }
        }
    }
}
