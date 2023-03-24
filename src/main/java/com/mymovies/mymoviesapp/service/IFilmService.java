package com.mymovies.mymoviesapp.service;

import com.mymovies.mymoviesapp.model.Film;

import java.util.List;

public interface IFilmService {

    Film create(Film film);

    Film get(String imdbID);

    List<Film> getAll();

    Film update(String imdbID, Film film);

    void delete(String imdbID);
}
