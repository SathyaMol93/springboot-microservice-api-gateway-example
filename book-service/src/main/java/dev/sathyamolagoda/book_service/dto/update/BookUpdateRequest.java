package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.BookBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * This class represents a request for updating a book.
 * It extends the BookBase class and adds a field for the last updated by XXXX.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookUpdateRequest extends BookBase {

    private String lastUpdatedBy;

}
