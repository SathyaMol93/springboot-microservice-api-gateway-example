package dev.sathyamolagoda.book_service.repository.impl;

import dev.sathyamolagoda.book_service.model.Review;
import dev.sathyamolagoda.book_service.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Review> getReviewTable() {
        return enhancedClient.table("author", TableSchema.fromBean(Review.class));
    }

    @Override
    public Optional<Review> findById(UUID id) {
        Review review= getReviewTable().getItem(r -> r.key(k -> k.partitionValue(id.toString())));
        return Optional.ofNullable(review);
    }

    @Override
    public List<Review> getReviewsByBookId(String bookId) {
        return getReviewTable().scan().items().stream().filter(r -> r.getBookId().equals(bookId)).toList();
    }

    @Override
    public Review save(Review review) {
        getReviewTable().putItem(review);
        return review;
    }

    @Override
    public void delete(UUID id) {
        getReviewTable().deleteItem(r -> r.key(k -> k.partitionValue(id.toString())));
    }
}
