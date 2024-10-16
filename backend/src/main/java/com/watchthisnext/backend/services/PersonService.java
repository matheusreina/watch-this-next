package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.person.PersonResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class PersonService {
    Dotenv dotenv = Dotenv.configure().load();
    private final String API_KEY = dotenv.get("API_KEY");
    private final String API_TOKEN = dotenv.get("API_TOKEN");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate;

    public PersonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PersonResponse getPersonDetails(String language, String personId) {
        String fullLanguage;
        if (language.equals("pt")) {
            fullLanguage = "pt-BR";
        } else {
            fullLanguage = "en-US";
        }

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/person/" + personId)
                .queryParam("api_key", API_KEY)
                .queryParam("language", fullLanguage)
                .queryParam("append_to_response", "combined_credits")
                .toUriString();

        return restTemplate.getForObject(url, PersonResponse.class);
    }
}
