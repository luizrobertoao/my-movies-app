package com.mymovies.mymoviesapp.service;

import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film create(Film film) {
        return null;
    }

    @Override
    public Film get(String imdbID) {
        return null;
    }

    @Override
    public List<Film> getAll() {
        return null;
    }

    @Override
    public Film update(String imdbID, Film film) {
        return null;
    }

    @Override
    public void delete(String imdbID) {

    }
}
