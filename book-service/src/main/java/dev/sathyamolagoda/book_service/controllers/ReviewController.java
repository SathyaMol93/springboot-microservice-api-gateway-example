package dev.sathyamolagoda.book_service.controllers;

import dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.ReviewResponse;
import dev.sathyamolagoda.book_service.dto.update.ReviewUpdateRequest;
import dev.sathyamolagoda.book_service.services.ReviewService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a REST controller that handles HTTP requests related to reviews.
 * It provides endpoints for creating, retrieving, updating, and deleting reviews.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * Retrieves a list of reviews for a specific book.
     * GET /api/v1/reviews/book/{bookId}
     *
     * @param bookId the ID of the book to retrieve reviews for
     * @return ResponseEntity containing a list of ReviewResponse objects
     */
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByBookId(@PathVariable String bookId) {
        List<ReviewResponse> reviews = reviewService.getReviewsByBookId(bookId);
        return ResponseEntity.ok(reviews);
    }

    /**
     * Creates a new review.
     * POST /api/v1/reviews
     *
     * @param reviewCreateRequest the ReviewCreateRequest object containing the review details
     * @return ResponseEntity containing the ReviewResponse object of the created review
     */
    @PostMapping
    public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        ReviewResponse created = reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.status(201).body(created); // HTTP 201 Created
    }

    /**
     * Updates an existing review.
     * PUT /api/v1/reviews/{id}
     *
     * @param id                  the ID of the review to update
     * @param reviewUpdateRequest the ReviewUpdateRequest object containing the updated review details
     * @return ResponseEntity containing the ReviewResponse object of the updated review
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponse> updateReview(
            @PathVariable String id,
            @RequestBody ReviewUpdateRequest reviewUpdateRequest
    ) {
        ReviewResponse updated = reviewService.updateReview(id, reviewUpdateRequest);
        return ResponseEntity.ok(updated);
    }

    /**
     * Deletes a review by its ID.
     * DELETE /api/v1/reviews/{id}
     *
     * @param id the ID of the review to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
