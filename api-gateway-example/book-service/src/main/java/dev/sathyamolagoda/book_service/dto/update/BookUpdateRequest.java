package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.BookBase;

import java.time.LocalDateTime;

public class BookUpdateRequest extends BookBase {

    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
