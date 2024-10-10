package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesResponse {
    private List<Image> logos;
    private List<Image> posters;
    private List<Image> backdrops;

    // Getters & Setters
    public List<Image> getLogos() {
        return logos;
    }
    public void setLogos(List<Image> logos) {
        this.logos = logos;
    }
    public List<Image> getPosters() {
        return posters;
    }
    public void setPosters(List<Image> posters) {
        this.posters = posters;
    }
    public List<Image> getBackdrops() {
        return backdrops;
    }
    public void setBackdrops(List<Image> backdrops) {
        this.backdrops = backdrops;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Image {
        @JsonProperty("file_path")
        private String filePath;

        @JsonProperty("iso_639_1")
        private String language;

        @JsonProperty("vote_average")
        private double voteAverage;

        private int height;
        private int width;


        // Getters & Setters
        public String getFilePath() {
            return filePath;
        }
        public void setFilePath(String filePath) {
            this.filePath = "https://image.tmdb.org/t/p/w500/" + filePath;
        }
        public String getLanguage() {
            return language;
        }
        public void setLanguage(String language) {
            this.language = language;
        }
        public double getVoteAverage() {
            return voteAverage;
        }
        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }
        public int getHeight() {
            return height;
        }
        public void setHeight(int height) {
            this.height = height;
        }
        public int getWidth() {
            return width;
        }
        public void setWidth(int width) {
            this.width = width;
        }
    }
}
