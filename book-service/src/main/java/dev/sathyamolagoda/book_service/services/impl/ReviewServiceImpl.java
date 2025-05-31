package dev.sathyamolagoda.book_service.services.impl;

import dev.sathyamolagoda.book_service.dto.response.ReviewResponse;
import dev.sathyamolagoda.book_service.dto.update.ReviewUpdateRequest;
import dev.sathyamolagoda.book_service.exception.BadRequestException;
import dev.sathyamolagoda.book_service.exception.ResourceNotFoundException;
import dev.sathyamolagoda.book_service.mapper.ReviewMapper;
import dev.sathyamolagoda.book_service.model.Review;
import dev.sathyamolagoda.book_service.repository.impl.ReviewRepositoryImpl;
import dev.sathyamolagoda.book_service.services.BookStatsService;
import dev.sathyamolagoda.book_service.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Implementation of the ReviewService interface.
 * Handles operations related to reviews.
 */
@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepositoryImpl reviewRepository;
    private final BookStatsService bookStatsService;

    /**
     * Retrieves all reviews for a given book ID.
     *
     * @param bookId The ID of the book for which reviews are to be retrieved.
     * @return A list of ReviewResponse objects representing the reviews for the book.
     */
    @Override
    public List<ReviewResponse> getReviewsByBookId(String bookId) {
        return reviewRepository.getReviewsByBookId(bookId).stream().map(ReviewMapper::toResponse).toList();
    }

    /**
     * Creates a new review.
     *
     * @param reviewCreateRequest The request object containing the review details.
     * @return A ReviewResponse object representing the created review.
     */
    @Override
    public ReviewResponse createReview(dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest reviewCreateRequest) {
        Review savedReview = reviewRepository.save(ReviewMapper.toEntity(reviewCreateRequest));
        bookStatsService.updateBookRatingAndReviewCount(savedReview.getBookId());
        return ReviewMapper.toResponse(savedReview);
    }

    /**
     * Updates an existing review.
     *
     * @param id                  The ID of the review to update.
     * @param reviewUpdateRequest The request object containing the updated review details.
     * @return A ReviewResponse object representing the updated review.
     * @throws ResourceNotFoundException If the review with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public ReviewResponse updateReview(String id, ReviewUpdateRequest reviewUpdateRequest) {
        try {
            Review existingReview = reviewRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
            ReviewMapper.updateEntity(existingReview, reviewUpdateRequest);
            Review updatedReview = reviewRepository.save(existingReview);
            if (!Objects.equals(existingReview.getRating(), updatedReview.getRating()))
                bookStatsService.updateBookRatingAndReviewCount(updatedReview.getBookId());
            return ReviewMapper.toResponse(updatedReview);
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }

    /**
     * Deletes a review by its ID.
     *
     * @param id The ID of the review to delete.
     * @throws ResourceNotFoundException If the review with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public void deleteReview(String id) {
        try {
            Review review = reviewRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Review not found with ID: " + id));
            reviewRepository.delete(review.getId());
            bookStatsService.updateBookRatingAndReviewCount(review.getBookId());
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }
}
