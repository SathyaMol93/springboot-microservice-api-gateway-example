package dev.sathyamolagoda.book_service.services.impl;

import dev.sathyamolagoda.book_service.dto.request.AuthorCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.update.AuthorUpdateRequest;
import dev.sathyamolagoda.book_service.exception.BadRequestException;
import dev.sathyamolagoda.book_service.exception.ResourceNotFoundException;
import dev.sathyamolagoda.book_service.mapper.AuthorMapper;
import dev.sathyamolagoda.book_service.model.Author;
import dev.sathyamolagoda.book_service.repository.AuthorRepository;
import dev.sathyamolagoda.book_service.services.AuthorService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of the AuthorService interface.
 * Provides methods for managing authors in the application.
 */
@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    /**
     * Retrieves a list of all authors.
     *
     * @return A list of AuthorResponse objects representing all authors.
     */
    @Override
    public List<AuthorResponse> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorMapper::toResponse)
                .toList();
    }

    /**
     * Retrieves an author by their ID.
     *
     * @param id The ID of the author to retrieve.
     * @return An AuthorResponse object representing the author.
     * @throws ResourceNotFoundException If the author with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public AuthorResponse findAuthorById(String id) {
        try {
            Author author = authorRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
            return AuthorMapper.toResponse(author);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }

    /**
     * Creates a new author.
     *
     * @param authorCreateRequest The request object containing the author details.
     * @return An AuthorResponse object representing the created author.
     */
    @Override
    public AuthorResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
        Author author = AuthorMapper.toEntity(authorCreateRequest);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.toResponse(savedAuthor);
    }

    /**
     * Updates an existing author.
     *
     * @param id                  The ID of the author to update.
     * @param authorUpdateRequest The request object containing the updated author details.
     * @return An AuthorResponse object representing the updated author.
     * @throws ResourceNotFoundException If the author with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public AuthorResponse updateAuthor(String id, AuthorUpdateRequest authorUpdateRequest) {
        try {
            Author author = authorRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
            AuthorMapper.updateEntity(author, authorUpdateRequest);
            Author updatedAuthor = authorRepository.save(author);
            return AuthorMapper.toResponse(updatedAuthor);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }

    /**
     * Deletes an author by their ID.
     *
     * @param id The ID of the author to delete.
     * @throws ResourceNotFoundException If the author with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public void deleteAuthor(String id) {
        try {
            Author author = authorRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
            authorRepository.delete(author.getId());
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException("Invalid UUID format: " + id);
        }
    }
}
