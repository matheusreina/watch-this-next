package com.watchthisnext.backend.models.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditsResponse {
    private List<Cast> cast;
    private List<Crew> crew;

    // Getters & Setters
    public List<Cast> getCast() {
        return cast;
    }
    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }
    public List<Crew> getCrew() {
        return crew;
    }
    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Cast {
        private String id;
        private String name;
        private int gender;

        @JsonProperty("original_name")
        private String originalName;

        @JsonProperty("known_for_department")
        private String department;

        private String character;

        @JsonProperty("profile_path")
        private String profilePath;

        private int order;

        // Getters & Setters
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
        public int getGender() {
            return gender;
        }
        public void setGender(int gender) {
            this.gender = gender;
        }
        public String getOriginalName() {
            return originalName;
        }
        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public String getCharacter() {
            return character;
        }
        public void setCharacter(String character) {
            this.character = character;
        }
        public String getProfilePath() {
            return profilePath;
        }
        public void setProfilePath(String profilePath) {
            this.profilePath = "https://image.tmdb.org/t/p/original/" +  profilePath;
        }
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Crew {
        private String id;
        private String name;
        private int gender;
        private final String profilePath = null;

        @JsonProperty("original_name")
        private String originalName;

        @JsonProperty("known_for_department")
        private String department;

        private String job;

        // Getters & Setters
        public String getJob() {
            return job;
        }
        public void setJob(String job) {
            this.job = job;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public String getOriginalName() {
            return originalName;
        }
        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }
        public int getGender() {
            return gender;
        }
        public void setGender(int gender) {
            this.gender = gender;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
    }
}
