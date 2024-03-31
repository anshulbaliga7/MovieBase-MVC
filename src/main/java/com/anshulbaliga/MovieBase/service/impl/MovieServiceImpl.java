package com.anshulbaliga.MovieBase.service.impl;

import com.anshulbaliga.MovieBase.model.entities.MovieEntity;
import com.anshulbaliga.MovieBase.repository.MovieRepository;
import com.anshulbaliga.MovieBase.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieEntity addMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieEntity> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieEntity updateMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }

    @Override
    public List<MovieEntity> findMoviesByGenre(String genre) {
        return movieRepository.findMoviesByGenre(genre);
    }

    @Override
    public List<MovieEntity> findMoviesByTitle(String title) {
        return movieRepository.findMoviesByTitle(title);
    }

    @Override
    public List<MovieEntity> findMoviesByYear(int year) {
        return movieRepository.findMoviesByYear(year);
    }

    @Override
    public List<MovieEntity> findMoviesByRating(double rating) {
        return movieRepository.findMoviesByRating(rating);
    }

    @Override
    public List<MovieEntity> findMoviesByRatingRange(double minRating, double maxRating) {
        return movieRepository.findMoviesByRatingRange(minRating, maxRating);
    }

    @Override
    public MovieEntity updateMovieRating(MovieEntity movieEntity, double rating) {
        double newRating = (movieEntity.getAverageRating() + rating) / 2;
        movieEntity.setAverageRating(newRating);
        return movieRepository.save(movieEntity);
    }
}
