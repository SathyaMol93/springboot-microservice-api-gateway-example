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

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepositoryImpl reviewRepository;
    private final BookStatsService bookStatsService;

    @Override
    public List<ReviewResponse> getReviewsByBookId(String bookId) {
        return reviewRepository.getReviewsByBookId(bookId).stream().map(ReviewMapper::toResponse).toList();
    }

    @Override
    public ReviewResponse createReview(dev.sathyamolagoda.book_service.dto.request.ReviewCreateRequest reviewCreateRequest) {
        Review savedReview = reviewRepository.save(ReviewMapper.toEntity(reviewCreateRequest));
        bookStatsService.updateBookRatingAndReviewCount(savedReview.getBookId());
        return ReviewMapper.toResponse(savedReview);
    }

    @Override
    public ReviewResponse updateReview(String id, ReviewUpdateRequest reviewUpdateRequest) {
        try {
            Review review = reviewRepository.findById(UUID.fromString(id)).orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + id));
            Review updatedReview = reviewRepository.save(ReviewMapper.updateEntity(review, reviewUpdateRequest));
            if (!Objects.equals(review.getRating(), updatedReview.getRating()))
                bookStatsService.updateBookRatingAndReviewCount(updatedReview.getBookId());
            return ReviewMapper.toResponse(updatedReview);
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }

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
