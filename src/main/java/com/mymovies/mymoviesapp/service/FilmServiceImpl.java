package com.mymovies.mymoviesapp.service;

import com.mymovies.mymoviesapp.gateway.OpenMovieGateway;
import com.mymovies.mymoviesapp.gateway.entity.OpenMovieResponse;
import com.mymovies.mymoviesapp.gateway.entity.Search;
import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private OpenMovieGateway openMovieGateway;

    @Override
    public Film create(String imdbID) {
        return filmRepository.save(openMovieGateway.findFilmById(imdbID));
    }

    @Override
    public Film get(String imdbID) {
        return filmRepository.findById(imdbID).get();
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public List<Search> getFilms(String filmTitle) {
        return openMovieGateway.findFilm(filmTitle).getSearch();
    }

    public List<Film> findByDirector(String director) {
        return filmRepository.filterByDirector(director);
    }

    public List<Film> findByTitle(String title) {
        return filmRepository.filterByTitle(title);
    }

    @Override
    public void delete(String imdbID) {
        filmRepository.deleteById(imdbID);
    }
}
