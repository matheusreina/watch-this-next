package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.episodes.SeasonsResponse;
import com.watchthisnext.backend.models.media.ImagesResponse;
import com.watchthisnext.backend.models.media.VideosResponse;
import com.watchthisnext.backend.models.person.CreditsResponse;
import com.watchthisnext.backend.models.tv.TvDetailsResponse;
import com.watchthisnext.backend.models.tv.TvResponse;
import com.watchthisnext.backend.utils.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TvService {
    Dotenv dotenv = Dotenv.configure().load();
    private final String API_KEY = dotenv.get("API_KEY");
    private final String API_TOKEN = dotenv.get("API_TOKEN");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public TvService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TvResponse getPopularTvs(String language) {
        String fullLanguage = language.equals("pt") ? "pt-BR" : "en-US";

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/popular")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        TvResponse results = restTemplate.getForObject(url, TvResponse.class);

        if (results != null) {
            List<TvResponse.Tv> popularTvs = results.getResults();

            for (TvResponse.Tv tv : popularTvs) {
                String date = tv.getFirstAirDate();
                tv.setFirstAirDate(AppUtils.dateFormatter(date, language));
            }

            results.setResults(popularTvs);
        }
        return results;
    }

    public TvResponse getTopRatedTvs(String language) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url =UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/top_rated")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        TvResponse results = restTemplate.getForObject(url, TvResponse.class);

        if (results != null) {
            List<TvResponse.Tv> topTvs = results.getResults();

            for (TvResponse.Tv tv : topTvs) {
                String date = tv.getFirstAirDate();
                tv.setFirstAirDate(AppUtils.dateFormatter(date, language));
            }

            results.setResults(topTvs);
        }
        return results;
    }

    public TvDetailsResponse getTvDetails(String language, String tvId) {
        String fullLanguage;
        final String FINAL_LANGUAGE;

        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
            FINAL_LANGUAGE = "pt";
        } else {
            fullLanguage = "en-US";
            FINAL_LANGUAGE = "en";
        }

        // Main request
        String tvUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        TvDetailsResponse tvDetails = restTemplate.getForObject(tvUrl, TvDetailsResponse.class);
        assert tvDetails != null;

        // Date formatting
        if (tvDetails.getFirstAirDate() != null && tvDetails.getNextEpisodeToAir() != null) {
            tvDetails.setFirstAirDate(AppUtils.dateFormatter(tvDetails.getFirstAirDate(), language));
            tvDetails.setNextEpisodeToAir(AppUtils.dateFormatter(tvDetails.getNextEpisodeToAir(), language));
        }

        // Videos request
        String videosUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/videos")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        VideosResponse videos = restTemplate.getForObject(videosUrl, VideosResponse.class);

        // Filtering video response for official=true & videoType="Trailer"
        if (videos != null) {
            List<VideosResponse.VideoResults> filteredVideos = videos.getResults().stream()
                    .filter(video -> video.isOfficial() && "Trailer".equalsIgnoreCase(video.getType())).toList();

            // Date formatting
            for (VideosResponse.VideoResults videoResults: filteredVideos) {
                String date = videoResults.getPublishedAt();
                videoResults.setPublishedAt(AppUtils.dateFormatter(date, language));
            }

            videos.setResults(filteredVideos);
        }

        tvDetails.setVideos(videos);

        // Images request
        String imagesUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/images")
                .queryParam("api_key", API_KEY)
                .toUriString();
        ImagesResponse images = restTemplate.getForObject(imagesUrl, ImagesResponse.class);

        // Filtering "/images" response
        if (images != null){

            List<ImagesResponse.Image> filteredLogoImages = images.getLogos().stream()
                    .filter(logo -> {
                        String lang = logo.getLanguage();
                        return lang == null || lang.equalsIgnoreCase(FINAL_LANGUAGE);
                    }).toList();

            List<ImagesResponse.Image> filteredPosterImages = images.getPosters().stream()
                    .filter(poster -> {
                        String lang = poster.getLanguage();
                        return lang == null || lang.equalsIgnoreCase(FINAL_LANGUAGE);
                    }).toList();

            List<ImagesResponse.Image> filteredBackdropImages = images.getBackdrops().stream()
                    .filter(backdrop -> {
                        String lang = backdrop.getLanguage();
                        return lang == null || lang.equalsIgnoreCase(FINAL_LANGUAGE);
                    }).toList();

            // Set filtered "/images" response
            images.setLogos(filteredLogoImages);
            images.setPosters(filteredPosterImages);
            images.setBackdrops(filteredBackdropImages);
        }

        tvDetails.setImages(images);

        // Credits request
        String creditsUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/credits")
                .queryParam("api_key", API_KEY)
                .toUriString();
        CreditsResponse credits = restTemplate.getForObject(creditsUrl, CreditsResponse.class);

        tvDetails.setCredits(credits);

        // Season & Episodes request
        List<SeasonsResponse> seasons = tvDetails.getSeasons();
        List<SeasonsResponse> newSeasons = new ArrayList<SeasonsResponse>();
        if (seasons != null) {
            String seasonUrl;
            for (int i = 0; i < seasons.size(); i++) {
                seasonUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/season/" + i)
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", fullLanguage)
                        .toUriString();
                newSeasons.add(restTemplate.getForObject(seasonUrl, SeasonsResponse.class));

            }

            tvDetails.setSeasons(newSeasons);
        }

        return tvDetails;
    }
}
