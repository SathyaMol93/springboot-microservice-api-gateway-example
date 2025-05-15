package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.ReviewBase;

import java.time.LocalDateTime;

public class ReviewUpdateRequest extends ReviewBase {

    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
