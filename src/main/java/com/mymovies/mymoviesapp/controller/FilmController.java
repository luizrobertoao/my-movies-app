package com.mymovies.mymoviesapp.controller;

import com.mymovies.mymoviesapp.gateway.entity.Search;
import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmServiceImpl filmService;

    @GetMapping("/search")
    public List<Search> findFilm(@RequestParam(value = "filmTitle") String filmTitle) {
        return filmService.getFilms(filmTitle);
    }

    @PostMapping("/mymovies")
    public Film create(@RequestParam(name = "imdbID") String imdbID) {
        return filmService.create(imdbID);
    }

    @GetMapping("/mymovies")
    public List<Film> getAll() {
        return filmService.getAll();
    }

    @DeleteMapping("/mymovies")
    public void delete(@RequestParam(name = "imdbID") String imdbID) {
        filmService.delete(imdbID);
    }

    @GetMapping("/mymovies/findbyid")
    public Film get(@RequestParam(name = "imdbID") String imdbID) {
        return filmService.get(imdbID);
    }

}
