package com.mymovies.mymoviesapp.controller;

import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.service.FilmServiceImpl;
import com.mymovies.mymoviesapp.service.dto.FilmServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController implements IFilmController {

    @Autowired
    private FilmServiceImpl filmService;


    @GetMapping(value = "/search", produces = "application/json")
    public ResponseEntity<FilmServiceDto> findFilm(@RequestParam(value = "filmTitle") String filmTitle) {
        FilmServiceDto body = filmService.getFilms(filmTitle);

        return ResponseEntity.status(HttpStatus.OK).body(body);
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

    @GetMapping("/mymovies/filter-by-id")
    public Film get(@RequestParam(name = "imdbID") String imdbID) {
        return filmService.get(imdbID);
    }

    @GetMapping("mymovies/filter-by-director")
    public List<Film> getByDirector(@RequestParam(name = "director") String director) {
        return filmService.findByDirector(director);
    }

    @GetMapping("mymovies/filter-by-title")
    public List<Film> getByTitle(@RequestParam(name = "title") String title) {
        return filmService.findByTitle(title);
    }

}
