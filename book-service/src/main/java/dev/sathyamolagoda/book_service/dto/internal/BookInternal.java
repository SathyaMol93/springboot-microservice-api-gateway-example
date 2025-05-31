package dev.sathyamolagoda.book_service.dto.internal;

import lombok.Data;

import java.util.UUID;

/**
 * This class represents an internal book object.
 * It is used to transfer book data between different components of the application or between other microservice.
 */
@SuppressWarnings("unused")
@Data
public class BookInternal {

    private UUID id;
    private String title;
    private String authorId;
    private double averageRating;
    private int reviewCount;

}
