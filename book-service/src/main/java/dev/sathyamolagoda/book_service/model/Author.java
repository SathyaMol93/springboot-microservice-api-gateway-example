package dev.sathyamolagoda.book_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

/**
 * This class represents an Author entity.
 * It extends the Base class and includes fields for author details.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class Author extends Base {

    private String name;
    private String country;
    private String birthDate;
    private String deathDate;
    private String biography;

    @DynamoDbPartitionKey
    public UUID getId() {
        return super.getId();
    }

}
