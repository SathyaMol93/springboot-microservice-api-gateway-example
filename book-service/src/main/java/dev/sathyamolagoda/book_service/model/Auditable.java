package dev.sathyamolagoda.book_service.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class represents an auditable entity.
 * It contains fields to track the creation and last update details of the entity.
 */
@Data
public abstract class Auditable {

    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
