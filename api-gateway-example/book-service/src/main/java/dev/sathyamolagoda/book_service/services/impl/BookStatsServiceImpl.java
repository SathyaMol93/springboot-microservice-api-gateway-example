package dev.sathyamolagoda.book_service.services.impl;

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

@AllArgsConstructor
@Service
public class BookStatsServiceImpl implements BookStatsService {

    private final ReviewRepositoryImpl reviewRepository;
    private final BookRepositoryImpl bookRepository;

    @Override
    public void updateBookRatingAndReviewCount(String bookId) {
        try {
            List<Review> reviews = reviewRepository.getReviewsByBookId(bookId);

            int count = reviews.size();
            double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);

            Book book = bookRepository.findById(UUID.fromString(bookId))
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with ID: " + bookId));
            book.setRating(String.format("%.2f", avg));
            book.setReviewCount(String.valueOf(count));
            bookRepository.save(book);
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid UUID format: " + bookId);
        }
    }
}

