package com.watchthisnext.backend.models.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.watchthisnext.backend.utils.AppUtils;

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

    @JsonProperty("combined_credits")
    private CombinedCreditsResponse combinedCredits;

    //Getters & Setters


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getDeathday() {
        return deathday;
    }
    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public String getHomepage() {
        return homepage;
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = "https://www.imdb.com/name/" + imdbId;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = AppUtils.imageLinkFormatter(profilePicture);
    }
    public CombinedCreditsResponse getCombinedCredits() {
        return combinedCredits;
    }
    public void setCombinedCredits(CombinedCreditsResponse combinedCredits) {
        this.combinedCredits = combinedCredits;
    }
}
