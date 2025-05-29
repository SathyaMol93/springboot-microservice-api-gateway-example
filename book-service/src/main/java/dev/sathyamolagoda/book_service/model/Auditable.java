package dev.sathyamolagoda.book_service.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class Auditable {

    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
