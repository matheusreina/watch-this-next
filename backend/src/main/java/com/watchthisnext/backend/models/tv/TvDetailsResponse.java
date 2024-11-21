package com.watchthisnext.backend.models.tv;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.models.episodes.SeasonsResponse;
import com.watchthisnext.backend.models.media.ImagesResponse;
import com.watchthisnext.backend.models.media.VideosResponse;
import com.watchthisnext.backend.models.person.CreditsResponse;
import com.watchthisnext.backend.utils.AppUtils;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvDetailsResponse {
    private String id;
    private String name;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("original_name")
    private String originalName;

    private String status;
    private String overview;
    private VideosResponse videos;
    private ImagesResponse images;
    private CreditsResponse credits;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("vote_average")
    private String voteAverage;

    @JsonProperty("first_air_date")
    private String firstAirDate;

    private String releaseYear;

    private List<Object> genres;

    @JsonProperty("number_of_episodes")
    private int numberOfEpisodes;

    @JsonProperty("number_of_seasons")
    private int numberOfSeasons;

    @JsonProperty("in_production")
    private boolean inProduction;

    @JsonProperty("next_episode_to_air")
    private Episode nextEpisodeToAir;

    @JsonProperty("last_episode_to_air")
    private Episode lastEpisodeToAir;

    private List<SeasonsResponse> seasons;

    @JsonProperty("production_countries")
    private List<Object> productionCountries;

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
    public String getOriginalName() {
        return originalName;
    }
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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
    public String getFirstAirDate() {
        return firstAirDate;
    }
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    public List<Object> getGenres() {
        return genres;
    }
    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }
    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }
    public boolean isInProduction() {
        return inProduction;
    }
    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }
    public Episode getNextEpisodeToAir() {
        return nextEpisodeToAir;
    }
    public void setNextEpisodeToAir(Episode nextEpisodeToAir) {
        this.nextEpisodeToAir = nextEpisodeToAir;
    }
    public Episode getLastEpisodeToAir() {
        return lastEpisodeToAir;
    }
    public void setLastEpisodeToAir(Episode lastEpisodeToAir) {
        this.lastEpisodeToAir = lastEpisodeToAir;
    }
    public List<SeasonsResponse> getSeasons() {
        return seasons;
    }
    public void setSeasons(List<SeasonsResponse> seasons) {
        this.seasons = seasons;
    }
    public List<Object> getProductionCountries() {
        return productionCountries;
    }
    public void setProductionCountries(List<Object> productionCountries) {
        this.productionCountries = productionCountries;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Episode {
        private String id;
        private String name;
        private String overview;

        @JsonProperty("vote_average")
        private String voteAverage;

        @JsonProperty("air_date")
        private String airDate;

        private String runtime;

        @JsonProperty("season_number")
        private String seasonNumber;

        @JsonProperty("show_id")
        private String showId;

        @JsonProperty("still_path")
        private String image;

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

        public String getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = AppUtils.voteAverageFormatter(voteAverage);
        }

        public String getAirDate() {
            return airDate;
        }

        public void setAirDate(String airDate) {
            this.airDate = airDate;
        }

        public String getRuntime() {
            return runtime;
        }

        public void setRuntime(String runtime) {
            this.runtime = runtime;
        }

        public String getSeasonNumber() {
            return seasonNumber;
        }

        public void setSeasonNumber(String seasonNumber) {
            this.seasonNumber = seasonNumber;
        }

        public String getShowId() {
            return showId;
        }

        public void setShowId(String showId) {
            this.showId = showId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            if (image != null) {
                this.image = AppUtils.imageLinkFormatter(image);
            } else {
            this.image = null;
            }
        }
    }

}

