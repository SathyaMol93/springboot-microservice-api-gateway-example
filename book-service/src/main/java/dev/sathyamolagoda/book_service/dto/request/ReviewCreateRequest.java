package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.ReviewBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReviewCreateRequest extends ReviewBase {

    private String createdBy;

}
