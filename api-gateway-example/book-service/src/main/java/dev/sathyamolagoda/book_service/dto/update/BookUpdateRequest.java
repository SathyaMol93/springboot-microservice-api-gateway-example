package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.BookBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookUpdateRequest extends BookBase {

    private String lastUpdatedBy;

}
