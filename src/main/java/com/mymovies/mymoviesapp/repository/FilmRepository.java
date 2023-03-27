package com.mymovies.mymoviesapp.repository;

import com.mymovies.mymoviesapp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, String> {

    @Query(value = "SELECT * FROM tb_films f WHERE f.director ILIKE %:director%", nativeQuery = true)
    List<Film> filterByDirector(String director);

    @Query(value = "SELECT * FROM tb_films f WHERE f.title ILIKE %:title%", nativeQuery = true)
    List<Film> filterByTitle(String title);

}
