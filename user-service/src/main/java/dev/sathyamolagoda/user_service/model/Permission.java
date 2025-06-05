package dev.sathyamolagoda.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.UUID;

/**
 * This class represents a Permission entity in the application.
 * It extends the Base class and includes additional fields for permission details.
 */
@EqualsAndHashCode(callSuper = true)
@DynamoDbBean
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends Base{

    private String name; // e.g., "user:create", "user:delete"
    private String description;

    @DynamoDbPartitionKey
    public UUID getId() {
        return super.getId();
    }

}
