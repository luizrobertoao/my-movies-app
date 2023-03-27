package com.mymovies.mymoviesapp.controller;

import com.mymovies.mymoviesapp.gateway.entity.Search;
import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.service.FilmServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmServiceImpl filmService;


    @GetMapping("/search")
    @Operation(summary = "Returns a list of films from OMDb API")
    public List<Search> findFilm(@RequestParam(value = "filmTitle") String filmTitle) {
        return filmService.getFilms(filmTitle);
    }

    @PostMapping("/mymovies")
    @Operation(summary = "Saves a movie to the personal movie catalog based on the movie Id.")
    public Film create(@RequestParam(name = "imdbID") String imdbID) {
        return filmService.create(imdbID);
    }

    @GetMapping("/mymovies")
    @Operation(summary = "Returns all the movies on the personal movie catalog.")
    public List<Film> getAll() {
        return filmService.getAll();
    }

    @DeleteMapping("/mymovies")
    @Operation(summary = "Deletes a movie from the personal movie catalog based on the movie Id.")
    public void delete(@RequestParam(name = "imdbID") String imdbID) {
        filmService.delete(imdbID);
    }

    @GetMapping("/mymovies/filter-by-id")
    @Operation(summary = "Returns a movie from movies catalog based on the movie Id.")
    public Film get(@RequestParam(name = "imdbID") String imdbID) {
        return filmService.get(imdbID);
    }

    @GetMapping("mymovies/filter-by-director")
    @Operation(summary = "Returns a list of movies from the movie catalog based on a director name")
    public List<Film> getByDirector(@RequestParam(name = "director") String director) {
        return filmService.findByDirector(director);
    }

    @GetMapping("mymovies/filter-by-title")
    @Operation(summary = "Returns a list of movies from the movie catalog based on a movie title")
    public List<Film> getByTitle(@RequestParam(name = "title") String title) {
        return filmService.findByTitle(title);
    }

}
