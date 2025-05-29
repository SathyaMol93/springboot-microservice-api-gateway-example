package dev.sathyamolagoda.book_service.services;

import dev.sathyamolagoda.book_service.dto.request.BookCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.BookResponse;
import dev.sathyamolagoda.book_service.dto.update.BookUpdateRequest;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();

    BookResponse getBookById(String id);

    BookResponse createBook(BookCreateRequest bookCreateRequest);

    BookResponse updateBook(String id, BookUpdateRequest bookUpdateRequest);

    void deleteBook(String id);
}
