package com.anshulbaliga.MovieBase.repository;

import com.anshulbaliga.MovieBase.model.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    @Query("SELECT m FROM MovieEntity m WHERE m.genre like %:genre%")
    List<MovieEntity> findMoviesByGenre(String genre);

    @Query("SELECT m FROM MovieEntity m WHERE m.title like %:title%")
    List<MovieEntity> findMoviesByTitle(String title);

    @Query("SELECT m FROM MovieEntity m WHERE YEAR(m.releaseDate) = :year")
    List<MovieEntity> findMoviesByYear(int year);

    @Query("SELECT m FROM MovieEntity m WHERE m.averageRating = :rating")
    List<MovieEntity> findMoviesByRating(double rating);

    @Query("SELECT m FROM MovieEntity m WHERE m.averageRating >= :minRating AND m.averageRating <= :maxRating")
    List<MovieEntity> findMoviesByRatingRange(double minRating, double maxRating);
}
