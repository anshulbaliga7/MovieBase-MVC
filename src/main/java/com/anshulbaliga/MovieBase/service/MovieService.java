package com.anshulbaliga.MovieBase.service;

import com.anshulbaliga.MovieBase.model.entities.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    MovieEntity addMovie(MovieEntity movieEntity);
    List<MovieEntity> getAllMovies();
    Optional<MovieEntity> getMovieById(Long id);

    void deleteMovie(Long id);

    MovieEntity updateMovie(MovieEntity movieEntity);

    MovieEntity updateMovieRating(MovieEntity movieEntity, double rating);

    List<MovieEntity> findMoviesByGenre(String genre);

    List<MovieEntity> findMoviesByTitle(String title);

    List<MovieEntity> findMoviesByYear(int year);

    List<MovieEntity> findMoviesByRating(double rating);

    List<MovieEntity> findMoviesByRatingRange(double minRating, double maxRating);
}
