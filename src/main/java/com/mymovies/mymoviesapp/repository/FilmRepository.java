package com.mymovies.mymoviesapp.repository;

import com.mymovies.mymoviesapp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, String> {

}
