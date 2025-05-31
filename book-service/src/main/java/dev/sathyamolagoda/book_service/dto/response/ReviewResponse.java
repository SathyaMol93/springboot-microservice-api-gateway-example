package dev.sathyamolagoda.book_service.dto.response;

import dev.sathyamolagoda.book_service.dto.base.ReviewBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents the response object for a Review.
 * It extends the ReviewBase class and adds additional fields for tracking
 * the creation and last update details of the Review.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ReviewResponse extends ReviewBase {

    private UUID id;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
