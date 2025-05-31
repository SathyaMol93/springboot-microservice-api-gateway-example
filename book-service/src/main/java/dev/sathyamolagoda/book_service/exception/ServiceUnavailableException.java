package dev.sathyamolagoda.book_service.exception;

/**
 * This class represents a custom exception that is thrown when a service is unavailable.
 * It extends the RuntimeException class and provides a constructor to set the exception message.
 */
public class ServiceUnavailableException extends RuntimeException {
    public ServiceUnavailableException(String message) {
        super(message);
    }
}
