package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.CreditsResponse;
import com.watchthisnext.backend.models.ImagesResponse;
import com.watchthisnext.backend.models.TvDetailsResponse;
import com.watchthisnext.backend.models.TvResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
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

        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
            language = "en";
        }

        final String FINAL_LANGUAGE = language;

        // Main request
        String tvUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .queryParam("append_to_response", "videos")
                .toUriString();
        TvDetailsResponse tvDetails = restTemplate.getForObject(tvUrl, TvDetailsResponse.class);
        assert tvDetails != null;

        // Filtering video response for official=true & videoType="Trailer"
        if (tvDetails.getVideos() != null) {
            List<TvDetailsResponse.Video.VideoResults> filteredVideos = tvDetails.getVideos().getResults().stream()
                    .filter(video -> video.isOfficial() && "Trailer".equalsIgnoreCase(video.getType())).toList();

            tvDetails.getVideos().setResults(filteredVideos);
        }

        // Images request
        String imagesUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/images")
                .queryParam("api_key", API_KEY)
                .queryParam("language", language)
                .toUriString();
        ImagesResponse images = restTemplate.getForObject(imagesUrl, ImagesResponse.class);

        // Filtering "/images" response
        if (images != null){

            System.out.println(images.getBackdrops().getFirst().getLanguage());
            List<ImagesResponse.Image> filteredLogoImages = images.getLogos().stream()
                    .filter(logo -> logo.getLanguage() == null || FINAL_LANGUAGE.equalsIgnoreCase(logo.getLanguage())).toList();

            List<ImagesResponse.Image> filteredPosterImages = images.getPosters().stream()
                    .filter(poster -> poster.getLanguage() == null || FINAL_LANGUAGE.equalsIgnoreCase(poster.getLanguage())).toList();

            List<ImagesResponse.Image> filteredBackdropImages = images.getBackdrops().stream()
                    .filter(backdrop -> backdrop.getLanguage() == null || FINAL_LANGUAGE.equalsIgnoreCase(backdrop.getLanguage())).toList();

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
