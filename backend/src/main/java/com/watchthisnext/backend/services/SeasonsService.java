package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.episodes.EpisodesResponse;
import com.watchthisnext.backend.models.episodes.SeasonsResponse;
import com.watchthisnext.backend.utils.*;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class SeasonsService {
    Dotenv dotenv = Dotenv.configure().load();
    private final String API_KEY = dotenv.get("API_KEY");
    private final String API_TOKEN = dotenv.get("API_TOKEN");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public SeasonsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SeasonsResponse getSeasons(String language, String tvId, int seasonNumber) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }

            String seasonUrl;
            seasonUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/season/" + seasonNumber)
                    .queryParam("api_key", API_KEY)
                    .queryParam("language", fullLanguage)
                    .toUriString();
        SeasonsResponse season = restTemplate.getForObject(seasonUrl, SeasonsResponse.class);

        // Date formatting
        assert season != null;
        String seasonDate = season.getAirDate();
        season.setAirDate(AppUtils.dateFormatter(seasonDate, language));

        List<EpisodesResponse> episodes = season.getEpisodes();
        for (EpisodesResponse episode: episodes) {
            String episodeDate = episode.getAirDate();
            episode.setAirDate(AppUtils.dateFormatter(episodeDate, language));
        }
        season.setEpisodes(episodes);

        if (season.getOverview().isEmpty()) {
            if (language.equals("pt")) {
                season.setOverview("Estamos sem uma sinopse no momento! :(");
            } else {
                season.setOverview("We don't have a overview yet! :(");
            }
        }
        return season;
    }
}
