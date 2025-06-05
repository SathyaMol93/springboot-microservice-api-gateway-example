package dev.sathyamolagoda.book_service.repository.impl;

import dev.sathyamolagoda.book_service.model.Author;
import dev.sathyamolagoda.book_service.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.*;

/**
 * This class implements the AuthorRepository interface and provides methods to interact with the Author entity.
 * It uses the DynamoDbEnhancedClient to perform CRUD operations on the Author table.
 */
@Repository
@AllArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Author> getAuthorTable() {
        return enhancedClient.table("author", TableSchema.fromBean(Author.class));
    }

    /**
     * Find author by id
     *
     * @param id - author id
     * @return Optional<Author>
     */
    @Override
    public Optional<Author> findById(UUID id) {
        return Optional.ofNullable(getAuthorTable().getItem(r -> r.key(k -> k.partitionValue(String.valueOf(id)))));
    }

    /**
     * Find authors by ids
     *
     * @param ids - author ids
     * @return List<Author>
     */
    @Override
    public List<Author> findAllById(Set<UUID> ids) {
        return ids.stream().map(id -> getAuthorTable().getItem(r -> r.key(k -> k.partitionValue(String.valueOf(id))))).toList();
    }

    /**
     * Find all authors
     *
     * @return List<Author>
     */
    @Override
    public List<Author> findAll() {
        return getAuthorTable().scan().items().stream().toList();
    }

    /**
     * Save author
     *
     * @param author - author
     * @return Author
     */
    @Override
    public Author save(Author author) {
        getAuthorTable().putItem(author);
        return author;
    }

    /**
     * Save all authors
     *
     * @param authors - authors
     * @return List<Author>
     */
    @Override
    public List<Author> saveAll(List<Author> authors) {
        authors.forEach(this::save);
        return authors;
    }

    /**
     * Delete author by id
     *
     * @param id - author id
     */
    @Override
    public void delete(UUID id) {
        getAuthorTable().deleteItem(r -> r.key(k -> k.partitionValue(id.toString())));
    }
}
