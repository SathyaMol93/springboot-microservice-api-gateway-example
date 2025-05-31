package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.ReviewBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * This class represents a request for creating a review.
 * It extends the ReviewBase class and adds a createdBy field.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ReviewCreateRequest extends ReviewBase {

    private String createdBy;

}
