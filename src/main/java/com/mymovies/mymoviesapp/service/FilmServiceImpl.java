package com.mymovies.mymoviesapp.service;

import com.mymovies.mymoviesapp.gateway.OpenMovieGateway;
import com.mymovies.mymoviesapp.gateway.entity.OpenMovieResponse;
import com.mymovies.mymoviesapp.model.Film;
import com.mymovies.mymoviesapp.repository.FilmRepository;
import com.mymovies.mymoviesapp.service.dto.FilmServiceDto;
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
    public FilmServiceDto getFilms(String filmTitle) {

        OpenMovieResponse response = openMovieGateway.findFilm(filmTitle);
        if (response.getResponse() == true) {
            return FilmServiceDto.builder()
                    .search(response.getSearch())
                    .response(response.getResponse())
                    .build();
        } else {
            return FilmServiceDto.builder()
                    .error(response.getError())
                    .response(response.getResponse())
                    .build();
        }

//    Example of exception handling by the own application
//    List<Search> getFilms(String filmTitle) throws FilmNotFoundException;
//        List<Search> films = openMovieGateway.findFilm(filmTitle).getSearch();
//        if (films != null) {
//            return films;
//        } else {
//            throw new FilmNotFoundException("Film not found.", filmTitle);
//        }
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
