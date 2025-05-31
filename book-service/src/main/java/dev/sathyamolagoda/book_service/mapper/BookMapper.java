package dev.sathyamolagoda.book_service.mapper;

import dev.sathyamolagoda.book_service.dto.internal.BookInternal;
import dev.sathyamolagoda.book_service.dto.request.BookCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.response.BookResponse;
import dev.sathyamolagoda.book_service.dto.update.BookUpdateRequest;
import dev.sathyamolagoda.book_service.model.Book;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class is responsible for mapping between Book entity and its corresponding DTOs.
 * It provides methods to convert from DTOs to entities and vice versa, as well as to update
 * existing entities with data from update requests.
 */
public class BookMapper {

    /**
     * This method converts a BookCreateRequest DTO to a Book entity.
     * It generates a unique ID for the book, sets the creation and update timestamps,
     * and copies the values from the DTO to the entity.
     * @param dto The BookCreateRequest DTO containing the book data.
     * @return The corresponding Book entity.
     */
    public static Book toEntity(BookCreateRequest dto) {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setIsbn(dto.getIsbn());
        book.setPublisher(dto.getPublisher());
        book.setPublishedDate(dto.getPublishedDate());
        book.setGenre(dto.getGenre());
        book.setLanguage(dto.getLanguage());
        book.setFormat(dto.getFormat());
        book.setEdition(dto.getEdition());
        book.setPageCount(dto.getPageCount());
        book.setAuthor(dto.getAuthorId());
        book.setCoverImage(dto.getCoverImage());
        book.setPrice(dto.getPrice());
        book.setCreatedBy(dto.getCreatedBy()); // This will be replaced by the logged user context in spring security example.
        book.setCreatedAt(LocalDateTime.now());
        book.setLastUpdatedBy(dto.getCreatedBy()); // This will be replaced by the logged user context in spring security example.
        book.setLastUpdatedAt(LocalDateTime.now());
        book.setRating("0");
        book.setReviewCount("0");
        return book;
    }

    /**
     * This method updates an existing Book entity with data from a BookUpdateRequest DTO.
     * It updates the entity's properties with the values from the DTO, except for the ID.
     * @param book The Book entity to be updated.
     * @param dto The BookUpdateRequest DTO containing the updated book data.
     */
    public static void updateEntity(Book book, BookUpdateRequest dto) {
        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setPublisher(dto.getPublisher());
        book.setGenre(dto.getGenre());
        book.setLanguage(dto.getLanguage());
        book.setFormat(dto.getFormat());
        book.setEdition(dto.getEdition());
        book.setPageCount(dto.getPageCount());
        book.setCoverImage(dto.getCoverImage());
        book.setPrice(dto.getPrice());
        book.setLastUpdatedBy(dto.getLastUpdatedBy()); // This will be replaced by the logged user context in spring security example.
        book.setLastUpdatedAt(LocalDateTime.now());
    }

    /**
     * This method converts a Book entity to a BookResponse DTO.
     * It copies the values from the entity to the DTO, including the author information.
     * @param book The Book entity to be converted.
     * @param author The AuthorResponse DTO containing the author information.
     * @return The corresponding BookResponse DTO.
     */
    public static BookResponse toResponse(Book book, AuthorResponse author) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setDescription(book.getDescription());
        response.setIsbn(book.getIsbn());
        response.setPublisher(book.getPublisher());
        response.setPublishedDate(book.getPublishedDate());
        response.setGenre(book.getGenre());
        response.setLanguage(book.getLanguage());
        response.setFormat(book.getFormat());
        response.setEdition(book.getEdition());
        response.setPageCount(book.getPageCount());
        response.setCoverImage(book.getCoverImage());
        response.setPrice(book.getPrice());
        response.setRating(book.getRating());
        response.setReviewCount(book.getReviewCount());
        response.setCreatedBy(book.getCreatedBy());
        response.setCreatedAt(book.getCreatedAt());
        response.setLastUpdatedBy(book.getLastUpdatedBy());
        response.setLastUpdatedAt(book.getLastUpdatedAt());
        response.setAuthor(author);
        return response;
    }

    /**
     * This method converts a Book entity to a BookInternal DTO.
     * It copies the values from the entity to the DTO, including the average rating and review count.
     * @param book The Book entity to be converted.
     * @return The corresponding BookInternal DTO.
     */
    public static BookInternal toInternal(Book book) {
        BookInternal internal = new BookInternal();
        internal.setId(book.getId());
        internal.setTitle(book.getTitle());
        internal.setAuthorId(book.getAuthor());
        try {
            internal.setAverageRating(Double.parseDouble(book.getRating()));
        } catch (NumberFormatException e) {
            internal.setAverageRating(0);
        }
        try {
            internal.setReviewCount(Integer.parseInt(book.getReviewCount()));
        } catch (NumberFormatException e) {
            internal.setReviewCount(0);
        }
        return internal;
    }
}
