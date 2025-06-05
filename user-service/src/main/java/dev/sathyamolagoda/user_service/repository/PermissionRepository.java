package dev.sathyamolagoda.user_service.repository;

import dev.sathyamolagoda.user_service.model.Permission;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

import java.util.List;

/**
 * This interface defines the contract for the PermissionRepository.
 * It provides methods to perform CRUD operations on Permission entities.
 */
public interface PermissionRepository {

    List<Permission> findAll();

    Permission save(Permission permission);

    List<Permission> saveAll(List<Permission> permissions);

    void delete(String id);
}
