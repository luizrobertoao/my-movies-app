package com.mymovies.mymoviesapp.gateway;

import com.mymovies.mymoviesapp.gateway.entity.OpenMovieResponse;
import com.mymovies.mymoviesapp.model.Film;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "openmovie", url = "https://www.omdbapi.com")
public interface OpenMovieGateway {

    @GetMapping("/?apikey=29e9926f&s={filmTitle}")
    OpenMovieResponse findFilm(@PathVariable("filmTitle") String filmTitle);

    @GetMapping("/?apikey=29e9926f&i={imdbID}")
    Film findFilmById(@PathVariable("imdbID") String imdbID);
}
