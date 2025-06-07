package dev.sathyamolagoda.book_service.repository;

import dev.sathyamolagoda.book_service.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface defines the contract for the BookRepository.
 * It provides methods to perform CRUD operations on Book entities.
 */
public interface BookRepository {

    Optional<Book> findById(UUID id);

    List<Book> findAll();

    Book save(Book book);

    List<Book> saveAll(List<Book> books);

    void delete(UUID id);
}
