package dev.sathyamolagoda.book_service.repository.impl;

import dev.sathyamolagoda.book_service.model.Author;
import dev.sathyamolagoda.book_service.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.*;

@Repository
@AllArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Author> getAuthorTable() {
        return enhancedClient.table("author", TableSchema.fromBean(Author.class));
    }

    @Override
    public Optional<Author> findById(UUID id) {
        Author author = getAuthorTable().getItem(r -> r.key(k -> k.partitionValue(String.valueOf(id))));
        return Optional.ofNullable(author);
    }

    @Override
    public List<Author> findAllById(Set<UUID> ids) {
        List<Author> authors = new ArrayList<>();
        ids.forEach(id -> authors.add(getAuthorTable().getItem(r -> r.key(k -> k.partitionValue(String.valueOf(id))))));
        return authors;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        getAuthorTable().scan().items().forEach(authors::add);
        return authors;
    }

    @Override
    public Author save(Author author) {
        getAuthorTable().putItem(author);
        return author;
    }

    @Override
    public List<Author> saveAll(List<Author> authors) {
        authors.forEach(this::save);
        return authors;
    }

    public void delete(UUID id) {
        getAuthorTable().deleteItem(r -> r.key(k -> k.partitionValue(id.toString())));
    }
}
