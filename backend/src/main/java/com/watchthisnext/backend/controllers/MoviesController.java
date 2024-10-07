package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.MoviesResponse;
import com.watchthisnext.backend.services.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    private final AppService appService;

    public MoviesController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/movie/popular")
    public MoviesResponse getPopularMovies() {
        return appService.getPopularMovies();
    }
}
