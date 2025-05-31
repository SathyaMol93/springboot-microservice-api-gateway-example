package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.ReviewBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * This class represents a request for updating a review.
 * It extends the ReviewBase class and adds a field for the last updated by XXXX.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ReviewUpdateRequest extends ReviewBase {

    private String lastUpdatedBy;

}
