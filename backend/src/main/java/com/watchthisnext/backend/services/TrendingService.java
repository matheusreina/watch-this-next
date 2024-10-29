package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.media.TrendingResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.watchthisnext.backend.utils.*;

import java.util.List;

@Service
public class TrendingService {
    Dotenv dotenv = Dotenv.configure().load();
    private final String API_KEY = dotenv.get("API_KEY");
    private final String API_TOKEN = dotenv.get("API_TOKEN");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public TrendingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TrendingResponse getTendingByDay(String language) {
        String fullLanguage = language.equals("pt") ? "pt-BR" : "en-US";

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/trending/all/day")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        TrendingResponse response = restTemplate.getForObject(url, TrendingResponse.class);

        if (response != null) {
            List<TrendingResponse.Media> trendMedia = response.getResults();

            for(TrendingResponse.Media media: trendMedia) {
                String date = media.getFirstAirDate() != null ? media.getFirstAirDate() : media.getReleaseDate();

                media.setDate(AppUtils.dateFormatter(date, language));
                if (media.getTitle() == null) {
                    media.setTitle(media.getName());
                }
            }
            response.setResults(trendMedia);
        }
        return response;
    }

    public TrendingResponse getTendingByWeek(String language) {
        String fullLanguage = language.equals("pt") ? "pt-BR" : "en-US";

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/trending/all/week")
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .toUriString();
        TrendingResponse response = restTemplate.getForObject(url, TrendingResponse.class);

        if (response != null) {
            List<TrendingResponse.Media> trendMedia = response.getResults();

            for(TrendingResponse.Media media: trendMedia) {
                String date = media.getReleaseDate();
                media.setReleaseDate(AppUtils.dateFormatter(date, language));
                if (media.getTitle() == null) {
                    media.setTitle(media.getName());
                }

            }
            response.setResults(trendMedia);
        }
        return response;
    }
}
