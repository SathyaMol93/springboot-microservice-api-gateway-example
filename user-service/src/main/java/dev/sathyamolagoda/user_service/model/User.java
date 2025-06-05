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
 * This class represents a User entity in the application.
 * It extends the Base class and includes additional fields for user details.
 */
@EqualsAndHashCode(callSuper = true)
@DynamoDbBean
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Base{

    private String username;
    private String email;
    private String fullName;
    private String phone;
    private List<String> roleIds;

    @DynamoDbPartitionKey
    public UUID getId() {
        return super.getId();
    }
}
