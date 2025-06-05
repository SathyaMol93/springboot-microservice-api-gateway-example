package dev.sathyamolagoda.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.List;
import java.util.UUID;

/**
 * This class represents a Role entity in the application.
 * It extends the Base class and includes additional fields for role details.
 */
@EqualsAndHashCode(callSuper = true)
@DynamoDbBean
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Base{

    private String name; // e.g., ADMIN, USER
    private String description;
    private List<String> permissionIds;

    @DynamoDbPartitionKey
    public UUID getId() {
        return super.getId();
    }
}
