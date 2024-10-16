package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.episodes.EpisodesResponse;
import com.watchthisnext.backend.models.episodes.SeasonsResponse;
import com.watchthisnext.backend.models.tv.TvDetailsResponse;
import com.watchthisnext.backend.models.tv.TvResponse;
import com.watchthisnext.backend.utils.AppUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<SeasonsResponse> getSeasons(String language, String tvId) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }

        String tvDetailsUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        TvDetailsResponse tvDetails = restTemplate.getForObject(tvDetailsUrl, TvDetailsResponse.class);

        // Season & Episodes request
        assert tvDetails != null;
        List<SeasonsResponse> seasons = tvDetails.getSeasons();
        List<SeasonsResponse> newSeasons = new ArrayList<>();
        if (seasons != null) {
            String seasonUrl;
            for (int i = 0; i < seasons.size(); i++) {
                seasonUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/season/" + i)
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", fullLanguage)
                        .toUriString();
                newSeasons.add(restTemplate.getForObject(seasonUrl, SeasonsResponse.class));
            }

            // Date formatting
            for (SeasonsResponse season : newSeasons) {
                String seasonDate = season.getAirDate();
                season.setAirDate(AppUtils.dateFormatter(seasonDate, language));

                List<EpisodesResponse> episodes = season.getEpisodes();
                for (EpisodesResponse episode: episodes) {
                    String episodeDate = episode.getAirDate();
                    episode.setAirDate(AppUtils.dateFormatter(episodeDate, language));
                }
                season.setEpisodes(episodes);
            }
        }
            return newSeasons;
    }

    public List<EpisodesResponse> getEpisodes(String language, String tvId, int seasonNumber) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }

        String seasonUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/season/" + seasonNumber)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        return Objects.requireNonNull(restTemplate.getForObject(seasonUrl, SeasonsResponse.class)).getEpisodes();

    }
}
