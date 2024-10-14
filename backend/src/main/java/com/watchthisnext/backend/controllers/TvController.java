package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.tv.TvDetailsResponse;
import com.watchthisnext.backend.models.tv.TvResponse;
import com.watchthisnext.backend.services.TvService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TvController {
    private final TvService tvService;

    public TvController(TvService tvService) {
        this.tvService = tvService;
    }

    @GetMapping("{language}/tv/popular")
    public TvResponse getPopularTvs (@PathVariable String language) {
        return tvService.getPopularTvs(language);
    }

    @GetMapping("{language}/tv/top_rated")
    public TvResponse getTopRatedTvs (@PathVariable String language) {
        return tvService.getTopRatedTvs(language);
    }

    @GetMapping("{language}/tv/{tvId}")
    public TvDetailsResponse getTvDetails(@PathVariable String language, @PathVariable String tvId) {
        return tvService.getTvDetails(language, tvId);
    }
}
