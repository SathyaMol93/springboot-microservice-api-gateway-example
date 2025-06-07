package dev.sathyamolagoda.book_service.constant;

public class ErrorMessages {

    // Common
    public static final String INVALID_UUID = "Invalid UUID format: %s";
    public static final String INVALID_UUID_IN_DATA = "Invalid UUID format in book data";

    // Book
    public static final String BOOK_NOT_FOUND = "Book not found with ID: %s";


    // Author
    public static final String AUTHOR_NOT_FOUND = "Author not found with ID: %s";

    // Review
    public static final String REVIEW_NOT_FOUND = "Review not found with ID: %s";

    private ErrorMessages() {
        // Prevent instantiation
    }
}
