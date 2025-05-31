package dev.sathyamolagoda.book_service.dto.response;

import dev.sathyamolagoda.book_service.dto.base.BookBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents the response object for a Book.
 * It extends the BookBase class and adds additional fields for tracking
 * the creation and last update details of the Book, as well as the author
 * and rating information.
 */
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
