package dev.sathyamolagoda.book_service.repository;

import dev.sathyamolagoda.book_service.model.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository {
    List<Review> getReviewsByBookId(String bookId);

    Review save(Review review);

    void delete(UUID id);
}
