package dev.sathyamolagoda.user_service.mapper;

import dev.sathyamolagoda.user_service.dto.request.UserCreateRequest;
import dev.sathyamolagoda.user_service.dto.response.PermissionResponse;
import dev.sathyamolagoda.user_service.dto.response.RoleResponse;
import dev.sathyamolagoda.user_service.dto.response.UserContext;
import dev.sathyamolagoda.user_service.dto.response.UserResponse;
import dev.sathyamolagoda.user_service.dto.update.UserUpdateRequest;
import dev.sathyamolagoda.user_service.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * This class is responsible for mapping between User entity and its corresponding DTOs.
 * It provides methods to convert from DTOs to entities and vice versa, as well as to update
 * existing entities with data from update requests.
 */
public class UserMapper {

    /**
     * This method converts a UserCreateRequest DTO to a User entity.
     * It generates a unique ID for the user, sets the creation and update timestamps,
     * and copies the values from the DTO to the entity.
     *
     * @param request The UserCreateRequest DTO containing the user data.
     * @return The corresponding User entity.
     */
    public static User toEntity(UserCreateRequest request) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        user.setAvatar(request.getAvatar());
        user.setRoleIds(request.getRoleIds());
        user.setCreatedBy(request.getCreatedBy());
        user.setCreatedAt(LocalDateTime.now());
        user.setLastUpdatedBy(request.getCreatedBy());
        user.setLastUpdatedAt(LocalDateTime.now());
        return user;
    }

    /**
     * This method updates an existing User entity with data from a UserUpdateRequest DTO.
     * It copies the values from the DTO to the entity, except for the ID, which is not updated.
     *
     * @param user    The User entity to be updated.
     * @param request The UserUpdateRequest DTO containing the updated user data.
     */
    public static void updateEntity(User user, UserUpdateRequest request) {
        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        user.setAvatar(request.getAvatar());
        user.setRoleIds(request.getRoleIds());
        user.setLastUpdatedBy(request.getLastUpdatedBy());
        user.setLastUpdatedAt(LocalDateTime.now());
    }

    /**
     * This method converts a User entity to a UserResponse DTO.
     * It copies the values from the entity to the DTO.
     *
     * @param user The User entity to be converted.
     * @return The corresponding UserResponse DTO.
     */
    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setCreatedBy(user.getCreatedBy());
        response.setCreatedAt(user.getCreatedAt());
        response.setLastUpdatedBy(user.getLastUpdatedBy());
        response.setLastUpdatedAt(user.getLastUpdatedAt());
        response.setUsername(user.getUsername());
        response.setFullName(user.getFullName());
        response.setPhone(user.getPhone());
        response.setAvatar(user.getAvatar());
        response.setRoleIds(user.getRoleIds());

        return response;
    }

    /**
     * This method converts a User entity and associated data (roles and permissions)
     * to a UserContext DTO.
     *
     * @param user        The User entity to be converted.
     * @param roles       A list of RoleResponse DTOs representing the user's roles.
     * @param permissions A list of PermissionResponse DTOs representing the user's permissions.
     * @return The corresponding UserContext DTO.
     */
    public static UserContext toContext(User user, List<RoleResponse> roles, List<PermissionResponse> permissions) {
        return new UserContext(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getEmail(),
                user.getPhone(),
                user.getAvatar(),
                roles,
                permissions,
                user.getCreatedBy(),
                user.getCreatedAt(),
                user.getLastUpdatedBy(),
                user.getLastUpdatedAt()
        );
    }
}
