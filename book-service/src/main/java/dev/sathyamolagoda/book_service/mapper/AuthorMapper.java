package dev.sathyamolagoda.book_service.mapper;

import dev.sathyamolagoda.book_service.dto.request.AuthorCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.update.AuthorUpdateRequest;
import dev.sathyamolagoda.book_service.model.Author;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuthorMapper {

    public static Author toEntity(AuthorCreateRequest dto) {
        Author author = new Author();
        author.setId(UUID.randomUUID());
        author.setName(dto.getName());
        author.setCountry(dto.getCountry());
        author.setBirthDate(dto.getBirthDate());
        author.setDeathDate(dto.getDeathDate());
        author.setBiography(dto.getBiography());
        author.setCreatedBy(dto.getCreatedBy()); // This will be replaced by the logged user context in spring security example.
        author.setCreatedAt(LocalDateTime.now());
        author.setLastUpdatedBy(dto.getCreatedBy()); // This will be replaced by the logged user context in spring security example.
        author.setLastUpdatedAt(LocalDateTime.now());
        return author;
    }

    public static void updateEntity(Author author, AuthorUpdateRequest dto) {
        author.setName(dto.getName());
        author.setCountry(dto.getCountry());
        author.setBirthDate(dto.getBirthDate());
        author.setDeathDate(dto.getDeathDate());
        author.setBiography(dto.getBiography());
        author.setLastUpdatedBy(dto.getLastUpdatedBy()); // This will be replaced by the logged user context in spring security example.
        author.setLastUpdatedAt(LocalDateTime.now());
    }

    public static AuthorResponse toResponse(Author author) {
        AuthorResponse response = new AuthorResponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setCountry(author.getCountry());
        response.setBirthDate(author.getBirthDate());
        response.setDeathDate(author.getDeathDate());
        response.setBiography(author.getBiography());
        response.setCreatedBy(author.getCreatedBy());
        response.setCreatedAt(author.getCreatedAt());
        response.setLastUpdatedBy(author.getLastUpdatedBy());
        response.setLastUpdatedAt(author.getLastUpdatedAt());
        return response;
    }
}
