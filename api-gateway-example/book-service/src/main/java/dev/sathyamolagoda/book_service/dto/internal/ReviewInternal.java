package dev.sathyamolagoda.book_service.dto.internal;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewInternal {

    private UUID id;
    private String bookId;
    private String rating;

}
