package com.anshulbaliga.MovieBase.repository;

import com.anshulbaliga.MovieBase.model.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    @Query("SELECT r FROM ReviewEntity r WHERE r.movie.id = :movieId")
    List<ReviewEntity> findReviewsByMovieId(Long movieId);

    @Query("SELECT r FROM ReviewEntity r WHERE r.user.id = :userId")
    List<ReviewEntity> findReviewsByUserId(Long userId);

    @Query("SELECT r FROM ReviewEntity r WHERE r.movie.id = :movieId AND r.user.id = :userId")
    List<ReviewEntity> findReviewsByMovieIdAndUserId(Long movieId, Long userId);

    @Query("SELECT r FROM ReviewEntity r WHERE r.rating = :rating")
    List<ReviewEntity> findReviewsByRating(Double rating);

    @Query("SELECT r FROM ReviewEntity r WHERE r.rating >= :minRating AND r.rating <= :maxRating")
    List<ReviewEntity> findReviewsByRatingRange(Double minRating, Double maxRating);
}