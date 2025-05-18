package dev.sathyamolagoda.book_service.controllers;

import dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.ReviewResponse;
import dev.sathyamolagoda.book_service.dto.update.ReviewUpdateRequest;
import dev.sathyamolagoda.book_service.services.ReviewService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // GET reviews by book ID
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByBookId(@PathVariable String bookId) {
        List<ReviewResponse> reviews = reviewService.getReviewsByBookId(bookId);
        return ResponseEntity.ok(reviews);
    }

    // POST a new review
    @PostMapping
    public ResponseEntity<ReviewResponse> createReview(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        ReviewResponse created = reviewService.createReview(reviewCreateRequest);
        return ResponseEntity.status(201).body(created); // HTTP 201 Created
    }

    // PUT update review
    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponse> updateReview(
            @PathVariable String id,
            @RequestBody ReviewUpdateRequest reviewUpdateRequest
    ) {
        ReviewResponse updated = reviewService.updateReview(id, reviewUpdateRequest);
        return ResponseEntity.ok(updated);
    }

    // DELETE review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
