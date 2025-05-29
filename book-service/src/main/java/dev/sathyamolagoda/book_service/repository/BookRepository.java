package dev.sathyamolagoda.book_service.repository;

import dev.sathyamolagoda.book_service.model.Book;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository {

    Optional<Book> findById(UUID id);

    List<Book> findAll();

    Book save(Book book);

    List<Book> saveAll(List<Book> books);

    void delete(UUID id);
}
