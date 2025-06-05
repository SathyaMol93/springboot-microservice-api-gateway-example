package dev.sathyamolagoda.user_service.repository.impl;

import dev.sathyamolagoda.user_service.model.Role;
import dev.sathyamolagoda.user_service.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This class implements the RoleRepository interface and provides methods to perform CRUD operations on Role entities.
 * It uses the DynamoDB enhanced client to interact with the DynamoDB table.
 */
@Repository
@AllArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<Role> getRoleTable() {
        return enhancedClient.table("role", TableSchema.fromBean(Role.class));
    }

    @Override
    public Optional<Role> findById(UUID id) {
        return Optional.ofNullable(getRoleTable().getItem(r -> r.key(k -> k.partitionValue(String.valueOf(id)))));
    }

    @Override
    public List<Role> findAll() {
        return getRoleTable().scan().items().stream().collect(Collectors.toList());
    }

    @Override
    public Role save(Role role) {
        getRoleTable().putItem(role);
        return role;
    }

    @Override
    public List<Role> saveAll(List<Role> roles) {
        roles.forEach(this::save);
        return roles;
    }

    @Override
    public void delete(UUID id) {
        getRoleTable().deleteItem(r -> r.key(k -> k.partitionValue(String.valueOf(id))));
    }
}
