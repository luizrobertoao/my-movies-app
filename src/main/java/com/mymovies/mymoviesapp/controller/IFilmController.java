package com.mymovies.mymoviesapp.controller;

import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.service.dto.FilmServiceDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "My Movie App",
                version = "v1",
                description = "Your personal movie catalog."))
public interface IFilmController {

    @Operation(summary = "Returns a list of films from OMDb API")
    ResponseEntity<FilmServiceDto> findFilm(@RequestParam(value = "filmTitle") String filmTitle);

    @Operation(summary = "Saves a movie to the personal movie catalog based on the movie Id.")
    Film create(@RequestParam(name = "imdbID") String imdbID);

    @Operation(summary = "Returns all the movies on the personal movie catalog.")
    List<Film> getAll();

    @Operation(summary = "Deletes a movie from the personal movie catalog based on the movie Id.")
    void delete(@RequestParam(name = "imdbID") String imdbID);

    @Operation(summary = "Returns a movie from movies catalog based on the movie Id.")
    Film get(@RequestParam(name = "imdbID") String imdbID);

    @Operation(summary = "Returns a list of movies from the movie catalog based on a director name")
    List<Film> getByDirector(@RequestParam(name = "director") String director);

    @Operation(summary = "Returns a list of movies from the movie catalog based on a movie title")
    List<Film> getByTitle(@RequestParam(name = "title") String title);
}
