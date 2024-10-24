package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.media.TrendingResponse;
import com.watchthisnext.backend.services.TrendingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrendingController {
    private final TrendingService trendingService;

    public TrendingController(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    @GetMapping("{language}/trending/all/day")
    public TrendingResponse getTendingByDay(@PathVariable String language) {
        return trendingService.getTendingByDay(language);
    }

    @GetMapping("{language}/trending/all/week")
    public TrendingResponse getTendingByWeek(@PathVariable String language) {
        return trendingService.getTendingByWeek(language);
    }
}
