package dev.sathyamolagoda.user_service.repository.impl;

import dev.sathyamolagoda.user_service.model.Permission;
import dev.sathyamolagoda.user_service.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

/**
 * Implementation of the PermissionRepository interface.
 * This class provides methods to interact with the Permission table in DynamoDB.
 */
@Repository
@AllArgsConstructor
public class PermissionRepositoryImpl implements PermissionRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    public DynamoDbTable<Permission> getPermissionTable() {
        return enhancedClient.table("permission", TableSchema.fromBean(Permission.class));
    }

    /**
     * Find all permissions
     *
     * @return List<Permission>
     */
    @Override
    public List<Permission> findAll() {
        return getPermissionTable().scan().items().stream().toList();
    }

    /**
     * Save permission
     *
     * @param permission - permission
     * @return Permission
     */
    @Override
    public Permission save(Permission permission) {
        getPermissionTable().putItem(permission);
        return permission;
    }

    /**
     * Save all permissions
     *
     * @param permissions - list of permissions
     * @return List<Permission>
     */
    @Override
    public List<Permission> saveAll(List<Permission> permissions) {
        permissions.forEach(this::save);
        return permissions;
    }

    /**
     * Delete permission by id
     *
     * @param id - permission id
     */
    @Override
    public void delete(String id) {
        getPermissionTable().deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
