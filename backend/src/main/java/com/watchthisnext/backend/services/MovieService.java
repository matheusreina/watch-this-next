package com.watchthisnext.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

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
}
