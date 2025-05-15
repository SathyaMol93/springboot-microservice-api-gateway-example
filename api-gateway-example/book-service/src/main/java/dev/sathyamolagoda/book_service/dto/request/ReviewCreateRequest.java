package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.ReviewBase;

import java.time.LocalDateTime;

public class ReviewCreateRequest extends ReviewBase {

    private String createdBy;
    private LocalDateTime createdAt;

}
