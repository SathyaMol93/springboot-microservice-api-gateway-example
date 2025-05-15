package dev.sathyamolagoda.book_service.dto.response;

import dev.sathyamolagoda.book_service.dto.base.BookBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookResponse extends BookBase {

    private UUID id;
    private String isbn;
    private String publishedDate;
    private AuthorResponse author;
    private String rating;
    private String reviewCount;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
