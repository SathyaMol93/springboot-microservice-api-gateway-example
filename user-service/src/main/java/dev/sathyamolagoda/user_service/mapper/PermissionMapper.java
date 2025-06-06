package dev.sathyamolagoda.user_service.mapper;

import dev.sathyamolagoda.user_service.dto.request.PermissionCreateRequest;
import dev.sathyamolagoda.user_service.dto.response.PermissionResponse;
import dev.sathyamolagoda.user_service.dto.update.PermissionUpdateRequest;
import dev.sathyamolagoda.user_service.model.Permission;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class is responsible for mapping between Permission entity and its corresponding DTOs.
 * It provides methods to convert from DTOs to entities and vice versa, as well as to update
 * existing entities with data from update requests.
 */
public class PermissionMapper {

    /**
     * This method converts a PermissionCreateRequest DTO to a Permission entity.
     * It generates a unique ID for the permission, sets the creation and update timestamps,
     * and copies the values from the DTO to the entity.
     *
     * @param request The PermissionCreateRequest DTO containing the permission data.
     * @return The corresponding Permission entity.
     */
    public static Permission toEntity(PermissionCreateRequest request) {
        Permission permission = new Permission();
        permission.setId(UUID.randomUUID());
        permission.setName(request.getName());
        permission.setDescription(request.getDescription());
        permission.setCreatedBy(request.getCreatedBy());
        permission.setCreatedAt(LocalDateTime.now());
        permission.setLastUpdatedBy(request.getCreatedBy());
        permission.setLastUpdatedAt(LocalDateTime.now());
        return permission;
    }

    /**
     * This method updates an existing Permission entity with data from a PermissionUpdateRequest DTO.
     * It updates the entity's properties with the values from the DTO, except for the ID.
     *
     * @param permission The Permission entity to be updated.
     * @param request The PermissionUpdateRequest DTO containing the updated permission data.
     */
    public static void toUpdatedEntity(Permission permission, PermissionUpdateRequest request) {
        permission.setName(request.getName());
        permission.setDescription(request.getDescription());
        permission.setLastUpdatedBy(request.getLastUpdatedBy());
        permission.setLastUpdatedAt(LocalDateTime.now());
    }

    /**
     * This method converts a Permission entity to a PermissionResponse DTO.
     * It copies the values from the entity to the DTO.
     *
     * @param permission The Permission entity to be converted.
     * @return The corresponding PermissionResponse DTO.
     */
    public static PermissionResponse toResponse(Permission permission) {
        return new PermissionResponse(
                permission.getId(),
                permission.getName(),
                permission.getDescription(),
                permission.getCreatedBy(),
                permission.getCreatedAt(),
                permission.getLastUpdatedBy(),
                permission.getLastUpdatedAt()
        );
    }


}
