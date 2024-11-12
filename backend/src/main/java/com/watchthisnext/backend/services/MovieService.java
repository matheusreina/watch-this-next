package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.media.ImagesResponse;
import com.watchthisnext.backend.models.media.VideosResponse;
import com.watchthisnext.backend.models.movie.MovieDetailsResponse;
import com.watchthisnext.backend.models.movie.MoviesResponse;
import com.watchthisnext.backend.models.person.CreditsResponse;
import com.watchthisnext.backend.utils.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
        MoviesResponse results = restTemplate.getForObject(url, MoviesResponse.class);

        if (results != null) {
            List<MoviesResponse.Movie> popularMovies = results.getResults();

            for (MoviesResponse.Movie movie : popularMovies) {
                String date = movie.getReleaseDate();
                movie.setReleaseDate(AppUtils.dateFormatter(date, language));

                // Media Type
                if (movie.getMediaType() == null){
                    movie.setMediaType("movie");
                }
            }

            results.setResults(popularMovies);
        }

        return results;
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
        MoviesResponse results = restTemplate.getForObject(url, MoviesResponse.class);

        if (results != null) {
            List<MoviesResponse.Movie> topMovies = results.getResults();

            for (MoviesResponse.Movie movie : topMovies) {
                String date = movie.getReleaseDate();
                movie.setReleaseDate(AppUtils.dateFormatter(date, language));

                // Media Type
                if (movie.getMediaType() == null){
                    movie.setMediaType("movie");
                }
            }

            results.setResults(topMovies);
        }
        return results;
    }

    public MovieDetailsResponse getMovieDetails(String language, String movieId) {
        String fullLanguage;
        final String FINAL_LANGUAGE;

        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
            FINAL_LANGUAGE = "pt";
        } else {
            fullLanguage = "en-US";
            FINAL_LANGUAGE = "en";
        }

        // Main Request
        String movieUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/" + movieId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        MovieDetailsResponse movieDetails = restTemplate.getForObject(movieUrl, MovieDetailsResponse.class);
        assert movieDetails != null;

        // Media Type
        if (movieDetails.getMediaType() == null){
            movieDetails.setMediaType("movie");
        }

        // Date formatting
        if (movieDetails.getReleaseDate() != null) {
            movieDetails.setReleaseYear(AppUtils.getReleaseYear(movieDetails.getReleaseDate()));
            movieDetails.setReleaseDate(AppUtils.dateFormatter(movieDetails.getReleaseDate(), language));
        }

        // Videos request
        String videosUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/" + movieId + "/videos")
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

        movieDetails.setVideos(videos);

        // Images request
        String imagesUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/" + movieId + "/images")
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

        movieDetails.setImages(images);

        // Credits request
        String creditsUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/movie/" + movieId + "/credits")
                .queryParam("api_key", API_KEY)
                .toUriString();
        CreditsResponse credits = restTemplate.getForObject(creditsUrl, CreditsResponse.class);

        movieDetails.setCredits(credits);

        return movieDetails;
    }

}
