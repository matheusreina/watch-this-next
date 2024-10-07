package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.MoviesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieService {
    @Value("${api.key}")
    private String API_KEY;

    @Value("${api.authToken}")
    private String API_TOKEN;

    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MoviesResponse getPopularMovies (String language) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/popular")
                                                .queryParam("api_key", API_KEY)
                                                .queryParam("language", language)
                                                .toUriString();
        return restTemplate.getForObject(url, MoviesResponse.class);
    }

    public MoviesResponse getTopRatedMovies (String language) {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/top_rated")
                .queryParam("api_key", API_KEY)
                .queryParam("language", language)
                .toUriString();
        return restTemplate.getForObject(url, MoviesResponse.class);
    }

}
