package dev.sathyamolagoda.book_service.controllers;

import dev.sathyamolagoda.book_service.dto.request.BookCreateRequest;
import dev.sathyamolagoda.book_service.dto.update.BookUpdateRequest;
import dev.sathyamolagoda.book_service.dto.response.BookResponse;
import dev.sathyamolagoda.book_service.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a REST controller that handles HTTP requests related to book operations.
 * It provides endpoints for retrieving, creating, updating, and deleting books.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    /**
     * Retrieves a list of all books.
     * GET /api/v1/books
     *
     * @return ResponseEntity containing a list of BookResponse objects
     */
    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    /**
     * Retrieves a book by its ID.
     * GET /api/v1/books/{id}
     *
     * @param id the ID of the book to retrieve
     * @return ResponseEntity containing the BookResponse object
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    /**
     * Creates a new book.
     * POST /api/v1/books
     *
     * @param bookCreateRequest the BookCreateRequest object containing the book details
     * @return ResponseEntity containing the BookResponse object of the created book
     */
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookCreateRequest bookCreateRequest) {
        return new ResponseEntity<>(bookService.createBook(bookCreateRequest), HttpStatus.CREATED);
    }

    /**
     * Updates an existing book.
     * PUT /api/v1/books/{id}
     *
     * @param id                the ID of the book to update
     * @param bookUpdateRequest the BookUpdateRequest object containing the updated book details
     * @return ResponseEntity containing the BookResponse object of the updated book
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable String id,
            @RequestBody BookUpdateRequest bookUpdateRequest
    ) {
        return ResponseEntity.ok(bookService.updateBook(id, bookUpdateRequest));
    }

    /**
     * Deletes a book by its ID.
     * DELETE /api/v1/books/{id}
     *
     * @param id the ID of the book to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
