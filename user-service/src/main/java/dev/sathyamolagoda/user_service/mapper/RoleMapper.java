package dev.sathyamolagoda.user_service.mapper;

import dev.sathyamolagoda.user_service.dto.request.RoleCreateRequest;
import dev.sathyamolagoda.user_service.dto.response.RoleResponse;
import dev.sathyamolagoda.user_service.dto.update.RoleUpdateRequest;
import dev.sathyamolagoda.user_service.model.Role;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class is responsible for mapping between Role entity and its corresponding DTOs.
 * It provides methods to convert from DTOs to entities and vice versa, as well as to update
 * existing entities with data from update requests.
 */
public class RoleMapper {

    /**
     * This method converts a RoleCreateRequest DTO to a Role entity.
     * It generates a unique ID for the role, sets the creation and update timestamps,
     * and copies the values from the DTO to the entity.
     *
     * @param request The RoleCreateRequest DTO containing the role data.
     * @return The corresponding Role entity.
     */
    public static Role toEntity(RoleCreateRequest request) {
        Role role = new Role();
        role.setId(UUID.randomUUID()); // Assuming new role creation
        role.setName(request.getName());
        role.setDescription(request.getDescription());
        role.setPermissionIds(request.getPermissionIds());
        role.setCreatedBy(request.getCreatedBy());
        role.setCreatedAt(LocalDateTime.now());
        role.setLastUpdatedBy(request.getCreatedBy());
        role.setLastUpdatedAt(LocalDateTime.now());
        return role;
    }

    /**
     * This method updates an existing Role entity with data from a RoleUpdateRequest DTO.
     * It updates the entity's properties with the values from the DTO, except for the ID.
     *
     * @param role The Role entity to be updated.
     * @param request The RoleUpdateRequest DTO containing the updated role data.
     */
    public static void toUpdatedEntity(Role role, RoleUpdateRequest request) {
        role.setDescription(request.getDescription());
        role.setPermissionIds(request.getPermissionIds());
        role.setLastUpdatedBy(request.getLastUpdatedBy());
        role.setLastUpdatedAt(LocalDateTime.now());
    }

    /**
     * This method converts a Role entity to a RoleResponse DTO.
     * It copies the values from the entity to the DTO.
     *
     * @param role The Role entity to be converted.
     * @return The corresponding RoleResponse DTO.
     */
    public static RoleResponse toResponse(Role role) {
        RoleResponse response = new RoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        response.setDescription(role.getDescription());
        response.setPermissionIds(role.getPermissionIds());
        response.setCreatedBy(role.getCreatedBy());
        response.setCreatedAt(role.getCreatedAt());
        response.setLastUpdatedBy(role.getLastUpdatedBy());
        response.setLastUpdatedAt(role.getLastUpdatedAt());
        return response;
    }
}
