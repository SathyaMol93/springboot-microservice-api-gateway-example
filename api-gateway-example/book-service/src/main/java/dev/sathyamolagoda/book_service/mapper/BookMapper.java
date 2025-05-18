package dev.sathyamolagoda.book_service.mapper;

import dev.sathyamolagoda.book_service.dto.internal.BookInternal;
import dev.sathyamolagoda.book_service.dto.request.BookCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.response.BookResponse;
import dev.sathyamolagoda.book_service.dto.update.BookUpdateRequest;
import dev.sathyamolagoda.book_service.model.Book;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookMapper {

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

    public static Book updateEntity(Book book, BookUpdateRequest dto) {
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
        return book;
    }

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
