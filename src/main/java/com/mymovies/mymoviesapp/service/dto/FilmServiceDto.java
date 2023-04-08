package com.mymovies.mymoviesapp.service.dto;

import com.mymovies.mymoviesapp.gateway.entity.Search;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FilmServiceDto {

    private String error;

    private List<Search> search;

    private Boolean response;
}
