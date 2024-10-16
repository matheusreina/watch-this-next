package com.watchthisnext.backend.services;

import com.watchthisnext.backend.models.person.CombinedCreditsResponse;
import com.watchthisnext.backend.models.person.PersonResponse;
import com.watchthisnext.backend.utils.AppUtils;
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
        PersonResponse results = restTemplate.getForObject(url, PersonResponse.class);

        // Date formatting
        if (results != null) {
            if (results.getBirthday() != null) {
                results.setBirthday(AppUtils.dateFormatter(results.getBirthday(), language));
            }
            if (results.getDeathday() != null) {
                results.setDeathday(AppUtils.dateFormatter(results.getDeathday(), language));
            }

            List<CombinedCreditsResponse.CastCredit> cast = results.getCombinedCredits().getCast();
            for (CombinedCreditsResponse.CastCredit castCredit : cast) {

                String releaseDate = castCredit.getReleaseDate();
                if (releaseDate != null) {
                    castCredit.setReleaseDate(AppUtils.dateFormatter(releaseDate, language));
                }

                String firstAirDate = castCredit.getFirstAirDate();
                if (firstAirDate != null) {
                    castCredit.setFirstAirDate(AppUtils.dateFormatter(firstAirDate, language));
                }
            }

            results.getCombinedCredits().setCast(cast);

            List<CombinedCreditsResponse.CrewCredit> crew = results.getCombinedCredits().getCrew();
            for (CombinedCreditsResponse.CrewCredit crewCredit : crew) {

                String releaseDate = crewCredit.getReleaseDate();
                if (releaseDate != null) {
                    crewCredit.setReleaseDate(AppUtils.dateFormatter(releaseDate, language));
                }

                String firstAirDate = crewCredit.getFirstAirDate();
                if (firstAirDate != null) {
                    crewCredit.setFirstAirDate(AppUtils.dateFormatter(firstAirDate, language));
                }
            }

            results.getCombinedCredits().setCrew(crew);
        }
        return results;
    }
}
