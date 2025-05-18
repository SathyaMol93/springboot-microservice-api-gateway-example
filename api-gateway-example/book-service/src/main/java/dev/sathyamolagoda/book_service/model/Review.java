package dev.sathyamolagoda.book_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Review extends Base {

    private String review;
    private String userId;
    private String userName;
    private String userAvatar;
    private String bookId;
    private Integer rating;

    @DynamoDbPartitionKey
    public UUID getId() {
        return super.getId();
    }

}
