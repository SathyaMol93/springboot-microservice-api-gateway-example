package dev.sathyamolagoda.user_service.model;

import dev.sathyamolagoda.book_service.model.Base;
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
