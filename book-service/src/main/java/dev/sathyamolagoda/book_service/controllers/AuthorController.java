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

/**
 * This class is a REST controller that handles HTTP requests related to authors.
 * It provides endpoints for creating, retrieving, updating, and deleting authors.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    /**
     * Retrieves a list of all authors.
     * GET /api/v1/authors
     *
     * @return ResponseEntity containing a list of AuthorResponse objects
     */
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    /**
     * Retrieves an author by their ID.
     * GET /api/v1/authors/{id}
     *
     * @param id the ID of the author to retrieve
     * @return ResponseEntity containing the AuthorResponse object
     */
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    /**
     * Creates a new author.
     * POST /api/v1/authors
     *
     * @param request the AuthorCreateRequest object containing the author details
     * @return ResponseEntity containing the AuthorResponse object of the created author
     */
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorCreateRequest request) {
        AuthorResponse createdAuthor = authorService.createAuthor(request);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    /**
     * Updates an existing author.
     * PUT /api/v1/authors/{id}
     *
     * @param id      the ID of the author to update
     * @param request the AuthorUpdateRequest object containing the updated author details
     * @return ResponseEntity containing the AuthorResponse object of the updated author
     */
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(
            @PathVariable String id,
            @RequestBody AuthorUpdateRequest request
    ) {
        AuthorResponse updatedAuthor = authorService.updateAuthor(id, request);
        return ResponseEntity.ok(updatedAuthor);
    }

    /**
     * Deletes an author by their ID.
     * DELETE /api/v1/authors/{id}
     *
     * @param id the ID of the author to delete
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
