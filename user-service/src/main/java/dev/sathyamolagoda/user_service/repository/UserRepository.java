package dev.sathyamolagoda.user_service.repository;

import dev.sathyamolagoda.user_service.model.User;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines the contract for the UserRepository.
 * It provides methods to perform CRUD operations on User entities.
 */
public interface UserRepository {
    Optional<User> findById(String id);

    List<User> getUsersByRoleId(String roleId);

    List<User> findAll();

    User save(User user);

    List<User> saveAll(List<User> users);

    void delete(String id);
}
