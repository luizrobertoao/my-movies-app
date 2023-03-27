package com.mymovies.mymoviesapp.controller;

import com.mymovies.mymoviesapp.gateway.entity.Search;
import com.mymovies.mymoviesapp.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmServiceImpl filmService;

    @GetMapping("/search")
    public List<Search> findFilm(@RequestParam(value = "filmTitle") String filmTitle) {
        return filmService.getFilms(filmTitle);
    }

//    @PostMapping
//    public Film create(@RequestParam(name = "filmTitle") String filmTitle) {
//        return filmService.create(filmTitle);
//    }
}
