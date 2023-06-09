package com.mymovies.mymoviesapp.gateway.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenMovieResponse {

    @JsonProperty("Error")
    private String error;

    @JsonProperty("Search")
    private List<Search> search;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private Boolean response;


//    @JsonProperty("Response")
//    public void setResponse(String response) {
//        this.response = Boolean.valueOf(response);
//    }

}
