package dev.sathyamolagoda.user_service.services;

import dev.sathyamolagoda.user_service.dto.request.PermissionCreateRequest;
import dev.sathyamolagoda.user_service.dto.response.PermissionResponse;
import dev.sathyamolagoda.user_service.dto.update.PermissionUpdateRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

/**
 * Service interface for managing permissions.
 * Provides methods for CRUD operations on permissions.
 */
public interface PermissionService {
    List<PermissionResponse> getAllPermissions();

    PermissionResponse createPermission(PermissionCreateRequest permissionCreateRequest);

    PermissionResponse getPermissionById(String id);

    PermissionResponse updatePermission(Long id, PermissionUpdateRequest permissionUpdateRequest);

    void deletePermission(String id);

    List<PermissionResponse> createPermissions(List<PermissionCreateRequest> permissionCreateRequests);
}
