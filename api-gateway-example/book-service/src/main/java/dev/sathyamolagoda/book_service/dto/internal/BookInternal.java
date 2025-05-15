package dev.sathyamolagoda.book_service.dto.internal;

import lombok.Data;

import java.util.UUID;

@Data
public class BookInternal {

    private UUID id;
    private String title;
    private String authorId;
    private double averageRating;
    private int reviewCount;

}
