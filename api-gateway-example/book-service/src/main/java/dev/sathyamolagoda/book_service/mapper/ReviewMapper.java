package dev.sathyamolagoda.book_service.mapper;

import dev.sathyamolagoda.book_service.dto.internal.ReviewInternal;
import dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.ReviewResponse;
import dev.sathyamolagoda.book_service.dto.update.ReviewUpdateRequest;
import dev.sathyamolagoda.book_service.model.Review;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReviewMapper {

    public static Review toEntity(ReviewCreateRequest dto) {
        Review review = new Review();
        review.setId(UUID.randomUUID());
        review.setReview(dto.getReview());
        review.setUserId(dto.getUserId());
        review.setUserName(dto.getUserName());
        review.setUserAvatar(dto.getUserAvatar());
        review.setBookId(dto.getBookId());
        review.setRating(dto.getRating());
        review.setCreatedBy(dto.getCreatedBy()); // This will be replaced by the logged user context in spring security example.
        review.setCreatedAt(LocalDateTime.now());
        review.setLastUpdatedBy(dto.getCreatedBy()); // This will be replaced by the logged user context in spring security example.
        review.setLastUpdatedAt(LocalDateTime.now());
        return review;
    }

    public static Review updateEntity(Review review, ReviewUpdateRequest dto) {
        review.setReview(dto.getReview());
        review.setUserId(dto.getUserId());
        review.setUserName(dto.getUserName());
        review.setUserAvatar(dto.getUserAvatar());
        review.setBookId(dto.getBookId());
        review.setRating(dto.getRating());
        review.setLastUpdatedBy(dto.getLastUpdatedBy()); // This will be replaced by the logged user context in spring security example.
        review.setLastUpdatedAt(LocalDateTime.now());
        return review;
    }

    public static ReviewResponse toResponse(Review review) {
        ReviewResponse response = new ReviewResponse();
        response.setId(review.getId());
        response.setReview(review.getReview());
        response.setUserId(review.getUserId());
        response.setUserName(review.getUserName());
        response.setUserAvatar(review.getUserAvatar());
        response.setBookId(review.getBookId());
        response.setRating(review.getRating());
        response.setCreatedBy(review.getCreatedBy());
        response.setCreatedAt(review.getCreatedAt());
        response.setLastUpdatedBy(review.getLastUpdatedBy());
        response.setLastUpdatedAt(review.getLastUpdatedAt());
        return response;
    }

    public static ReviewInternal toInternal(Review review) {
        ReviewInternal internal = new ReviewInternal();
        internal.setId(review.getId());
        internal.setBookId(review.getBookId());
        internal.setRating(review.getRating());
        return internal;
    }
}
