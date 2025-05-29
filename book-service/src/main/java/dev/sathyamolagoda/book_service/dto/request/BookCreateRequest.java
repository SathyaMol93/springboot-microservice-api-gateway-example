package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.BookBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookCreateRequest extends BookBase {

    private String isbn;
    private String publishedDate;
    private String authorId;
    private String createdBy;

}
