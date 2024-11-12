package com.watchthisnext.backend.models.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.models.media.ImagesResponse;
import com.watchthisnext.backend.models.media.VideosResponse;
import com.watchthisnext.backend.models.person.CreditsResponse;
import com.watchthisnext.backend.utils.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailsResponse {
    private String id;
    private String title;

    @JsonProperty("media_type")
    private String mediaType;

    private String status;
    private String overview;
    private String runtime;
    private VideosResponse videos;
    private ImagesResponse images;
    private CreditsResponse credits;

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private String voteAverage;

    @JsonProperty("release_date")
    private String releaseDate;

    private String releaseYear;

    private Object[] genres;

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
    public String getMediaType() {
        return mediaType;
    }
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
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
    public VideosResponse getVideos() {
        return videos;
    }
    public void setVideos(VideosResponse videos) {
        this.videos = videos;
    }
    public ImagesResponse getImages() {
        return images;
    }
    public void setImages(ImagesResponse images) {
        this.images = images;
    }
    public CreditsResponse getCredits() {
        return credits;
    }
    public void setCredits(CreditsResponse credits) {
        this.credits = credits;
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
        this.backdropPath = AppUtils.imageLinkFormatter(backdropPath);
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = AppUtils.imageLinkFormatter(posterPath);
    }
    public String getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = AppUtils.voteAverageFormatter(voteAverage);
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    public Object[] getGenres() {
        return genres;
    }
    public void setGenres(Object[] genres) {
        this.genres = genres;
    }
    public Object[] getProductionCountries() {
        return productionCountries;
    }
    public void setProductionCountries(Object[] productionCountries) {
        this.productionCountries = productionCountries;
    }
}
