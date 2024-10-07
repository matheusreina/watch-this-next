package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.MoviesResponse;
import com.watchthisnext.backend.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    private final MovieService movieService;

    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("{language}/movie/popular")
    public MoviesResponse getPopularMovies(@PathVariable String language) {
        return movieService.getPopularMovies(language);
    }

    @GetMapping("{language}/movie/top_rated")
    public MoviesResponse getTopRatedMovies(@PathVariable String language) {
        return movieService.getTopRatedMovies(language);
    }
}
