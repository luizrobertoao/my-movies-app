package com.mymovies.mymoviesapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Class not in use exception is handled by the OpenMovieAPI response using FilmServiceDTO.
// This class is just an example of the syntax.

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = FilmNotFoundException.class)
    protected ResponseEntity<Object> handleFilmNotFoundException(
            FilmNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage() + request.toString(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
