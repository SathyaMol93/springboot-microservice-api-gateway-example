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

/**
 * This class implements the ReviewRepository interface and provides methods to interact with the Review entity.
 * It uses the DynamoDbEnhancedClient to perform CRUD operations on the Review table.
 */
@Repository
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Review> getReviewTable() {
        return enhancedClient.table("author", TableSchema.fromBean(Review.class));
    }

    /**
     * Find review by id
     * @param id - review id
     * @return Optional<Review>
     */
    @Override
    public Optional<Review> findById(UUID id) {
        Review review= getReviewTable().getItem(r -> r.key(k -> k.partitionValue(id.toString())));
        return Optional.ofNullable(review);
    }

    /**
     * Find reviews by book id
     * @param bookId - book id
     * @return List<Review>
     */
    @Override
    public List<Review> getReviewsByBookId(String bookId) {
        return getReviewTable().scan().items().stream().filter(r -> r.getBookId().equals(bookId)).toList();
    }

    /**
     * Save review
     * @param review - review
     * @return Review
     */
    @Override
    public Review save(Review review) {
        getReviewTable().putItem(review);
        return review;
    }

    /**
     * Delete review by id
     * @param id - review id
     */
    @Override
    public void delete(UUID id) {
        getReviewTable().deleteItem(r -> r.key(k -> k.partitionValue(id.toString())));
    }
}
