package dev.sathyamolagoda.book_service.dto.internal;

import lombok.Data;

import java.util.UUID;

/**
 * This class represents an internal review object.
 * It is used to transfer review data between different components of the application or between other microservice.
 */
@SuppressWarnings("unused")
@Data
public class ReviewInternal {

    private UUID id;
    private String bookId;
    private Integer rating;

}
