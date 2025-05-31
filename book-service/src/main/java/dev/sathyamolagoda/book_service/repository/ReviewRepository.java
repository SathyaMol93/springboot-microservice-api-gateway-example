package dev.sathyamolagoda.book_service.repository;

import dev.sathyamolagoda.book_service.model.Review;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface defines the contract for the ReviewRepository.
 * It provides methods to perform CRUD operations on Review entities.
 */
public interface ReviewRepository {
    Optional<Review> findById(UUID id);

    List<Review> getReviewsByBookId(String bookId);

    Review save(Review review);

    void delete(UUID id);
}
