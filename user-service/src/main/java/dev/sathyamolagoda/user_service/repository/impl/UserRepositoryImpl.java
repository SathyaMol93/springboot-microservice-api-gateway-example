package dev.sathyamolagoda.user_service.repository.impl;

import dev.sathyamolagoda.user_service.model.User;
import dev.sathyamolagoda.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserRepository interface.
 * This class provides methods to interact with the User table in DynamoDB.
 */
@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DynamoDbEnhancedClient enhancedClient;

    private DynamoDbTable<User> getUserTable() {
        return enhancedClient.table("user", TableSchema.fromBean(User.class));
    }

    /**
     * Find user by id
     *
     * @param id - user id
     * @return Optional<User>
     */
    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(getUserTable().getItem(r -> r.key(k -> k.partitionValue(id))));
    }

    /**
     * Find users by role id
     *
     * @param roleId - role id
     * @return List<User>
     */
    @Override
    public List<User> getUsersByRoleId(String roleId) {
        return getUserTable().scan().items().stream().filter(user ->
                user.getRoleIds() != null && user.getRoleIds().stream().anyMatch(role ->
                        role.equals(roleId))).toList();
    }

    /**
     * Find all users
     *
     * @return List<User>
     */
    @Override
    public List<User> findAll() {
        return getUserTable().scan().items().stream().toList();
    }

    /**
     * Save user
     *
     * @param user - user
     * @return User
     */
    @Override
    public User save(User user) {
        getUserTable().putItem(user);
        return user;
    }

    /**
     * Save all users
     *
     * @param users - list of users
     * @return List<User>
     */
    @Override
    public List<User> saveAll(List<User> users) {
        users.forEach(this::save);
        return users;
    }

    /**
     * Delete user by id
     *
     * @param id - user id
     */
    @Override
    public void delete(String id) {
        getUserTable().deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
