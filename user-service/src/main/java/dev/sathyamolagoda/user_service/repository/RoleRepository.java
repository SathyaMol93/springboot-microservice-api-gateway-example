package dev.sathyamolagoda.user_service.repository;

import dev.sathyamolagoda.user_service.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface defines the contract for the RoleRepository.
 * It provides methods to perform CRUD operations on Role entities.
 */
public interface RoleRepository {
    Optional<Role> findById(UUID id);

    List<Role> findAll();

    Role save(Role role);

    List<Role> saveAll(List<Role> roles);

    void delete(UUID id);
}
