package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/popular")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        return restTemplate.getForObject(url, TvResponse.class);
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
        return restTemplate.getForObject(url, TvResponse.class);
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

        return tvDetails;
    }
}
