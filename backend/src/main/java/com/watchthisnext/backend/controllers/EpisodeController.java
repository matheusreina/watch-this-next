package com.watchthisnext.backend.controllers;

import com.watchthisnext.backend.models.episodes.EpisodeDetailsResponse;
import com.watchthisnext.backend.models.episodes.EpisodeGroupResponse;
import com.watchthisnext.backend.services.EpisodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpisodeController {
    private final EpisodeService tvEpisodesService;

    public EpisodeController(EpisodeService tvEpisodesService) {
        this.tvEpisodesService = tvEpisodesService;
    }

    @GetMapping("{language}/tv/details/{tvId}/episodes")
    public EpisodeGroupResponse getEpisodeGroup(@PathVariable String language, @PathVariable String tvId) {
        return tvEpisodesService.getEpisodeGroup(language, tvId);
    }

    @GetMapping("{language}/tv/details/{tvId}/episodes/{epGroupId}")
    public EpisodeDetailsResponse getEpisodeList(@PathVariable String language, @PathVariable String tvId ,@PathVariable String epGroupId) {
        return tvEpisodesService.getEpisodeList(language, epGroupId);
    }
}
