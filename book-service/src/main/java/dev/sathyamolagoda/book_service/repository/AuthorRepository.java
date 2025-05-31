package dev.sathyamolagoda.book_service.repository;

import dev.sathyamolagoda.book_service.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * This interface defines the contract for the AuthorRepository.
 * It provides methods to perform CRUD operations on Author entities.
 */
public interface AuthorRepository {
    Optional<Author> findById(UUID id);

    List<Author> findAllById(Set<UUID> ids);

    List<Author> findAll();

    Author save(Author author);

    List<Author> saveAll(List<Author> authors);

    void delete(UUID id);
}
