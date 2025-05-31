package dev.sathyamolagoda.book_service.mapper;

import dev.sathyamolagoda.book_service.dto.request.AuthorCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.update.AuthorUpdateRequest;
import dev.sathyamolagoda.book_service.model.Author;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class is responsible for mapping between Author entity and its corresponding DTOs.
 * It provides methods to convert from DTOs to entities and vice versa, as well as to update
 * existing entities with data from update requests.
 */
public class AuthorMapper {

    /**
     * This method converts an AuthorCreateRequest DTO to an Author entity.
     * It generates a unique ID for the author, sets the creation and update timestamps,
     * and copies the values from the DTO to the entity.
     * @param dto The AuthorCreateRequest DTO containing the author data.
     * @return The corresponding Author entity.
     */
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

    /**
     * This method updates an existing Author entity with data from an AuthorUpdateRequest DTO.
     * It updates the entity's properties with the values from the DTO, except for the ID.
     * @param author The Author entity to be updated.
     * @param dto The AuthorUpdateRequest DTO containing the updated author data.
     */
    public static void updateEntity(Author author, AuthorUpdateRequest dto) {
        author.setName(dto.getName());
        author.setCountry(dto.getCountry());
        author.setBirthDate(dto.getBirthDate());
        author.setDeathDate(dto.getDeathDate());
        author.setBiography(dto.getBiography());
        author.setLastUpdatedBy(dto.getLastUpdatedBy()); // This will be replaced by the logged user context in spring security example.
        author.setLastUpdatedAt(LocalDateTime.now());
    }

    /**
     * This method converts an Author entity to an AuthorResponse DTO.
     * It copies the values from the entity to the DTO.
     * @param author The Author entity to be converted.
     * @return The corresponding AuthorResponse DTO.
     */
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
