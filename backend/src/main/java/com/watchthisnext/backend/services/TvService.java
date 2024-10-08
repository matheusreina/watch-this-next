package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.TvDetailsResponse;
import com.watchthisnext.backend.models.TvResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/popular")
                                            .queryParam("api_key", API_KEY)
                                            .queryParam("language", language)
                                            .toUriString();
        return restTemplate.getForObject(url, TvResponse.class);
    }

    public TvResponse getTopRatedTvs(String language) {
        String url =UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/top_rated")
                .queryParam("api_key", API_KEY)
                .queryParam("language", language)
                .toUriString();
        return restTemplate.getForObject(url, TvResponse.class);
    }

    public TvDetailsResponse getTvDetails(String language, String tvId) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", language)
                .toUriString();
        return restTemplate.getForObject(url, TvDetailsResponse.class);
    }
}
