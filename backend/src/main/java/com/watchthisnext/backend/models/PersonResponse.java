package com.watchthisnext.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResponse {
    private String id;
    private String name;
    private String birthday;
    private String deathday;
    private String gender;
    private String biography;
    private String homepage;

    @JsonProperty("place_of_birth")
    private String placeOfBirth;

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonProperty("known_for_department")
    private String department;

    @JsonProperty("profile_path")
    private String profilePicture;

//    @JsonProperty("combined_credits")
//    Verify if this data can be used with CreditsResponse

}
