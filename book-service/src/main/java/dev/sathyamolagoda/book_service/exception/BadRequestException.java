package dev.sathyamolagoda.book_service.exception;

/**
 * This class represents a custom exception that is thrown when a bad request is encountered.
 * It extends the RuntimeException class and provides a constructor to set the exception message.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
