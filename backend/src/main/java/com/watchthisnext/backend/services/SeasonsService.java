package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.episodes.SeasonsResponse;
import com.watchthisnext.backend.models.tv.TvDetailsResponse;
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

        assert tvDetails != null;
        return tvDetails.getSeasons();


//        if (tvDetails != null) {
//            List<SeasonsResponse> seasons = tvDetails.getSeasons();
//            int numberOfSeasons = seasons.size();
//            String seasonsQueryParam = "season/";
//        }
    }

//    public TvDetailsResponse getEpisodes(String language, String tvId) {
//        String fullLanguage;
//        if (language.equals("pt")) {
//            fullLanguage = "pt-BR";
//        } else {
//            fullLanguage = "en-US";
//        }
//        String tvDetailsUrl = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/tv/" + tvId)
//                .queryParam("api_key", API_KEY)
//                .queryParam("language", fullLanguage)
//                .toUriString();
//        TvDetailsResponse tvDetails =  restTemplate.getForObject(tvDetailsUrl, TvDetailsResponse.class);
//
//        return tvDetails;
//
//        if (tvDetails != null) {
//            List<SeasonsResponse> seasons = tvDetails.getSeasons();
//            int numberOfSeasons = seasons.size();
//            String seasonsQueryModel = "season/";
//            List<String> seasonsQueryParam = new ArrayList<String>();
//
//            for (int i = 0; i < numberOfSeasons; i++) {
//                seasonsQueryParam.add(seasonsQueryModel + i);
//            }
//
//
//        }
//    }
}
