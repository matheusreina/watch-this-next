package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.MovieDetailsResponse;
import com.watchthisnext.backend.models.MoviesResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieService {
    Dotenv dotenv = Dotenv.configure().load();
    private final String API_KEY = dotenv.get("API_KEY");
    private final String API_TOKEN = dotenv.get("API_TOKEN");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MoviesResponse getPopularMovies (String language) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/popular")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        return restTemplate.getForObject(url, MoviesResponse.class);
    }

    public MoviesResponse getTopRatedMovies (String language) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/top_rated")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        return restTemplate.getForObject(url, MoviesResponse.class);
    }

    public MovieDetailsResponse getMovieDetails(String language, String movieId) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/" + movieId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .queryParam("append_to_response", "videos")
                .toUriString();
        return restTemplate.getForObject(url, MovieDetailsResponse.class);
    }

}
