package dev.sathyamolagoda.book_service.exception;

/**
 * This class represents a custom exception that is thrown when a requested resource is not found.
 * It extends the RuntimeException class and provides a constructor to set the exception message.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}