package dev.sathyamolagoda.book_service.services.impl;

import dev.sathyamolagoda.book_service.constant.ErrorMessages;
import dev.sathyamolagoda.book_service.exception.BadRequestException;
import dev.sathyamolagoda.book_service.exception.ResourceNotFoundException;
import dev.sathyamolagoda.book_service.model.Book;
import dev.sathyamolagoda.book_service.model.Review;
import dev.sathyamolagoda.book_service.repository.impl.BookRepositoryImpl;
import dev.sathyamolagoda.book_service.repository.impl.ReviewRepositoryImpl;
import dev.sathyamolagoda.book_service.services.BookStatsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of the BookStatsService interface.
 * This class handles the business logic related to book statistics.
 */
@AllArgsConstructor
@Service
public class BookStatsServiceImpl implements BookStatsService {

    private final ReviewRepositoryImpl reviewRepository;
    private final BookRepositoryImpl bookRepository;

    /**
     * Updates the rating and review count of a book based on the reviews associated with it.
     *
     * @param bookId The ID of the book to update.
     * @throws ResourceNotFoundException If the book is not found.
     * @throws BadRequestException       If the provided bookId is not a valid UUID.
     */
    @Override
    public void updateBookRatingAndReviewCount(String bookId) {
        try {
            List<Review> reviews = reviewRepository.getReviewsByBookId(bookId);

            int count = reviews.size();
            double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);

            Book book = bookRepository.findById(UUID.fromString(bookId))
                    .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.BOOK_NOT_FOUND + bookId));
            book.setRating(String.format("%.2f", avg));
            book.setReviewCount(String.valueOf(count));
            bookRepository.save(book);
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException(ErrorMessages.INVALID_UUID + bookId);
        }
    }
}

