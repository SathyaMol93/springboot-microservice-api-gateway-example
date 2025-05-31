package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.BookBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * This class represents a request for creating a book.
 * It extends the BookBase class and adds fields for ISBN, published date, author ID, and created by.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BookCreateRequest extends BookBase {

    private String isbn;
    private String publishedDate;
    private String authorId;
    private String createdBy;

}
