package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.EpisodeDetailsResponse;
import com.watchthisnext.backend.models.EpisodeGroupResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class EpisodeService {
    Dotenv dotenv = Dotenv.configure().load();
    private final String API_KEY = dotenv.get("API_KEY");
    private final String API_TOKEN = dotenv.get("API_TOKEN");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public EpisodeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EpisodeGroupResponse getEpisodeGroup(String language, String tvId) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId + "/episode_groups")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        return restTemplate.getForObject(url, EpisodeGroupResponse.class);
    }

    public EpisodeDetailsResponse getEpisodeList(String language, String epGroupId) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/episode_group/" + epGroupId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        return restTemplate.getForObject(url, EpisodeDetailsResponse.class);
    }
}
