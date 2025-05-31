package dev.sathyamolagoda.book_service.services;

/**
 * This interface defines the contract for the BookStatsService.
 * It provides a method to update the rating and review count of a book.
 */
public interface BookStatsService {
    void updateBookRatingAndReviewCount(String bookId);
}
