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

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    // GET /api/v1/books
    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // GET /api/v1/books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // POST /api/v1/books
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookCreateRequest bookCreateRequest) {
        return new ResponseEntity<>(bookService.createBook(bookCreateRequest), HttpStatus.CREATED);
    }

    // PUT /api/v1/books/{id}
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable String id,
            @RequestBody BookUpdateRequest bookUpdateRequest
    ) {
        return ResponseEntity.ok(bookService.updateBook(id, bookUpdateRequest));
    }

    // DELETE /api/v1/books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
