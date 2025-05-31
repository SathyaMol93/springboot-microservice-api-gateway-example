package dev.sathyamolagoda.book_service.services;

import dev.sathyamolagoda.book_service.dto.response.ReviewResponse;
import dev.sathyamolagoda.book_service.dto.update.ReviewUpdateRequest;

import java.util.List;

/**
 * Service interface for managing reviews.
 * Provides methods for CRUD operations on reviews.
 */
public interface ReviewService {
    List<ReviewResponse> getReviewsByBookId(String bookId);

    ReviewResponse createReview(dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest reviewCreateRequest);

    ReviewResponse updateReview(String id, ReviewUpdateRequest reviewUpdateRequest);

    void deleteReview(String id);
}
