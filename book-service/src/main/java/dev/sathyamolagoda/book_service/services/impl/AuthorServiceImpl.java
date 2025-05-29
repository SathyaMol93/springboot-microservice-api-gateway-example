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

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<AuthorResponse> findAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(AuthorMapper::toResponse)
                .toList();
    }

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

    @Override
    public AuthorResponse createAuthor(AuthorCreateRequest authorCreateRequest) {
        Author author = AuthorMapper.toEntity(authorCreateRequest);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.toResponse(savedAuthor);
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
        }
    }
}
