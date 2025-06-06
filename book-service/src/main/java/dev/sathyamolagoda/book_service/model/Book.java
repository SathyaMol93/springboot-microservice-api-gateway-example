package dev.sathyamolagoda.book_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

/**
 * This class represents a Book entity.
 * It extends the Base class and includes fields for book details.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Book extends Base {

    private String title;
    private String description;
    private String isbn;
    private String publisher;
    private String publishedDate;
    private String genre;
    private String language;
    private String format;
    private String edition;
    private String pageCount;
    private String author;
    private String coverImage;
    private String price;
    private String rating;
    private String reviewCount;

    @DynamoDbPartitionKey
    public UUID getId() {
        return super.getId();
    }

}
