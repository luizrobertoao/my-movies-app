package com.mymovies.mymoviesapp.exception;

// Class not in use exception is handled by the OpenMovieAPI response using FilmServiceDTO.
// This class is just an example of the syntax.

public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException(String message, String filmTitle) {
        super(filmTitle + message);
    }
}


