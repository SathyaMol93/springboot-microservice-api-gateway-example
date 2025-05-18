package dev.sathyamolagoda.book_service.controllers;

import dev.sathyamolagoda.book_service.dto.request.AuthorCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.update.AuthorUpdateRequest;
import dev.sathyamolagoda.book_service.services.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    // GET /api/v1/authors
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    // GET /api/v1/authors/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    // POST /api/v1/authors
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorCreateRequest request) {
        AuthorResponse createdAuthor = authorService.createAuthor(request);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    // PUT /api/v1/authors/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(
            @PathVariable String id,
            @RequestBody AuthorUpdateRequest request
    ) {
        AuthorResponse updatedAuthor = authorService.updateAuthor(id, request);
        return ResponseEntity.ok(updatedAuthor);
    }

    // DELETE /api/v1/authors/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
