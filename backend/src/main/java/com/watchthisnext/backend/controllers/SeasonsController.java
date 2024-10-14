package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.episodes.EpisodesResponse;
import com.watchthisnext.backend.models.episodes.SeasonsResponse;
import com.watchthisnext.backend.services.SeasonsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeasonsController {
    private final SeasonsService seasonsService;

    public SeasonsController(SeasonsService seasonsService) {
        this.seasonsService = seasonsService;
    }

    @GetMapping("{language}/tv/details/{tvId}/seasons")
    public List<SeasonsResponse> getSeasons(@PathVariable String language, @PathVariable String tvId) {
        return seasonsService.getSeasons(language, tvId);
    }

//    @GetMapping("{language}/tv/details/{tvId}/episodes/{epGroupId}")
//    public EpisodesResponse getEpisodes(@PathVariable String language, @PathVariable String tvId) {
//        return seasonsService.getEpisodes(language, tvId);
//    }
}
