package dev.sathyamolagoda.book_service.services.impl;

import dev.sathyamolagoda.book_service.dto.request.AuthorCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.update.AuthorUpdateRequest;
import dev.sathyamolagoda.book_service.exception.ResourceNotFoundException;
import dev.sathyamolagoda.book_service.mapper.AuthorMapper;
import dev.sathyamolagoda.book_service.model.Author;
import dev.sathyamolagoda.book_service.repository.AuthorRepository;
import dev.sathyamolagoda.book_service.services.AuthorService;
import jakarta.ws.rs.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorResponse> findAllAuthors() {
        try {
            List<Author> authors = authorRepository.findAll();
            if (authors.isEmpty()) {
                throw new ResourceNotFoundException("No authors found in the database");
            }
            return authors.stream()
                    .map(AuthorMapper::toResponse)
                    .toList();
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error while retrieving authors", ex);
        }
    }

    @Override
    public AuthorResponse findAuthorById(String id) {
        try {
            Author author = authorRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
            return AuthorMapper.toResponse(author);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException("Invalid UUID format: " + id);
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error while retrieving author", ex);
        }
    }

    @Override
    public AuthorResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
        try {
            Author author = AuthorMapper.toEntity(authorCreateRequest);
            Author savedAuthor = authorRepository.save(author);
            return AuthorMapper.toResponse(savedAuthor);
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while creating author", ex);
        }
    }

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
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while updating author", ex);
        }
    }

    @Override
    public void deleteAuthor(String id) {
        try {
            Author author = authorRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + id));
            authorRepository.delete(author.getId());
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException("Invalid UUID format: " + id);
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected error occurred while deleting author", ex);
        }
    }
}
