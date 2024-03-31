package com.anshulbaliga.MovieBase.service;

import com.anshulbaliga.MovieBase.model.entities.MovieEntity;
import com.anshulbaliga.MovieBase.model.entities.ReviewEntity;
import com.anshulbaliga.MovieBase.model.entities.UserEntity;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<ReviewEntity> getReviewById(Long id);
    ReviewEntity addReview(ReviewEntity reviewEntity, UserEntity user, MovieEntity movie);
//    ReviewEntity getReviewById(Long id);
//    List<ReviewEntity> getAllReviews();
//    ReviewEntity updateReview(ReviewEntity reviewEntity);
//    void deleteReview(Long id);
    List<ReviewEntity> findReviewsByMovieId(Long movieId);
    List<ReviewEntity> findReviewsByUserId(Long userId);

    void deleteReview(Long id);

    ReviewEntity updateReview(ReviewEntity reviewEntity);

    List<ReviewEntity> getAllReviews();
}
