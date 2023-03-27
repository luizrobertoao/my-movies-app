package com.mymovies.mymoviesapp.service;

import com.mymovies.mymoviesapp.gateway.entity.Search;
import com.mymovies.mymoviesapp.model.Film;

import java.util.List;

public interface IFilmService {

    Film create(String filmTitle);

    Film get(String imdbID);

    List<Film> getAll();

    List<Search> getFilms(String filmTitle);

    Film update(String imdbID, Film film);

    void delete(String imdbID);
}
