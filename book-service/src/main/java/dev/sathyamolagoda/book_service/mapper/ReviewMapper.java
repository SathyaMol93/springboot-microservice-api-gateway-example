package dev.sathyamolagoda.book_service.mapper;

import dev.sathyamolagoda.book_service.dto.internal.ReviewInternal;
import dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.ReviewResponse;
import dev.sathyamolagoda.book_service.dto.update.ReviewUpdateRequest;
import dev.sathyamolagoda.book_service.model.Review;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class is responsible for mapping between Review entity and its corresponding DTOs.
 * It provides methods to convert from DTOs to entities and vice versa, as well as to update
 * existing entities with data from update requests.
 */
public class ReviewMapper {

    /**
     * This method converts a ReviewCreateRequest DTO to a Review entity.
     * It generates a unique ID for the review, sets the creation and update timestamps,
     * and copies the values from the DTO to the entity.
     *
     * @param dto The ReviewCreateRequest DTO containing the review data.
     * @return The corresponding Review entity.
     */
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

    /**
     * This method updates an existing Review entity with data from a ReviewUpdateRequest DTO.
     * It updates the entity's properties with the values from the DTO.
     *
     * @param review The Review entity to be updated.
     * @param dto    The ReviewUpdateRequest DTO containing the updated review data.
     */
    public static void updateEntity(Review review, ReviewUpdateRequest dto) {
        review.setReview(dto.getReview());
        review.setUserId(dto.getUserId());
        review.setUserName(dto.getUserName());
        review.setUserAvatar(dto.getUserAvatar());
        review.setBookId(dto.getBookId());
        review.setRating(dto.getRating());
        review.setLastUpdatedBy(dto.getLastUpdatedBy()); // This will be replaced by the logged user context in spring security example.
        review.setLastUpdatedAt(LocalDateTime.now());
    }

    /**
     * This method converts a Review entity to a ReviewResponse DTO.
     * It copies the values from the entity to the DTO.
     *
     * @param review The Review entity to be converted.
     * @return The corresponding ReviewResponse DTO.
     */
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

    /**
     * This method converts a Review entity to a ReviewInternal DTO.
     * It copies the values from the entity to the DTO.
     *
     * @param review The Review entity to be converted.
     * @return The corresponding ReviewInternal DTO.
     */
    public static ReviewInternal toInternal(Review review) {
        ReviewInternal internal = new ReviewInternal();
        internal.setId(review.getId());
        internal.setBookId(review.getBookId());
        internal.setRating(review.getRating());
        return internal;
    }
}
