package com.mymovies.mymoviesapp.service;

import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.service.dto.FilmServiceDto;

import java.util.List;

public interface IFilmService {

    Film create(String imdbID);

    Film get(String imdbID);

    List<Film> getAll();

//    Example of exception handling by the own application
//    List<Search> getFilms(String filmTitle) throws FilmNotFoundException;
    FilmServiceDto getFilms(String filmTitle);

    void delete(String imdbID);
}
