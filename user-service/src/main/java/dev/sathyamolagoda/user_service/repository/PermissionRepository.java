package dev.sathyamolagoda.user_service.repository;

import dev.sathyamolagoda.user_service.model.Permission;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines the contract for the PermissionRepository.
 * It provides methods to perform CRUD operations on Permission entities.
 */
public interface PermissionRepository {

    List<Permission> findAll();

    Optional<Permission> findById(String id);

    Permission save(Permission permission);

    List<Permission> saveAll(List<Permission> permissions);

    void delete(String id);
}
