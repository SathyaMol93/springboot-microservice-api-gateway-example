package dev.sathyamolagoda.user_service.services.impl;

import dev.sathyamolagoda.user_service.constant.ErrorMessages;
import dev.sathyamolagoda.user_service.dto.request.PermissionCreateRequest;
import dev.sathyamolagoda.user_service.dto.response.PermissionResponse;
import dev.sathyamolagoda.user_service.dto.update.PermissionUpdateRequest;
import dev.sathyamolagoda.user_service.exception.BadRequestException;
import dev.sathyamolagoda.user_service.exception.ResourceNotFoundException;
import dev.sathyamolagoda.user_service.mapper.PermissionMapper;
import dev.sathyamolagoda.user_service.model.Permission;
import dev.sathyamolagoda.user_service.repository.PermissionRepository;
import dev.sathyamolagoda.user_service.services.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the PermissionService interface.
 * Provides methods for managing permissions in the application.
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    /**
     * Retrieves a list of all permissions.
     *
     * @return A list of PermissionResponse objects representing all permissions.
     */
    @Override
    public List<PermissionResponse> getAllPermissions() {
        return permissionRepository.findAll().stream()
                .map(PermissionMapper::toResponse)
                .toList();
    }

    /**
     * Creates a new permission.
     *
     * @param permissionCreateRequest The request object containing the details of the permission to be created.
     * @return A PermissionResponse object representing the created permission.
     */
    @Override
    public PermissionResponse createPermission(PermissionCreateRequest permissionCreateRequest) {
        return PermissionMapper.toResponse(permissionRepository
                .save(PermissionMapper
                        .toEntity(permissionCreateRequest)));
    }

    /**
     * Retrieves a permission by its ID.
     *
     * @param id The ID of the permission to retrieve.
     * @return A PermissionResponse object representing the retrieved permission.
     * @throws ResourceNotFoundException If the permission with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public PermissionResponse getPermissionById(String id) {
        try {
            Permission permission = permissionRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PERMISSION_NOT_FOUND + id));
            return PermissionMapper.toResponse(permission);
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(ErrorMessages.INVALID_UUID + id);
        }
    }

    /**
     * Updates an existing permission.
     *
     * @param id                      The ID of the permission to update.
     * @param permissionUpdateRequest The request object containing the updated details of the permission.
     * @return A PermissionResponse object representing the updated permission.
     * @throws ResourceNotFoundException If the permission with the given ID is not found.
     * @throws BadRequestException       If the provided ID is not a valid UUID.
     */
    @Override
    public PermissionResponse updatePermission(Long id, PermissionUpdateRequest permissionUpdateRequest) {
        try {
            Permission permission = permissionRepository.findById(id.toString())
                    .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PERMISSION_NOT_FOUND + id));

            PermissionMapper.toUpdatedEntity(permission, permissionUpdateRequest);

            return PermissionMapper.toResponse(permissionRepository.save(permission));
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(ErrorMessages.INVALID_UUID + id);
        }
    }

    @Override
    public void deletePermission(String id) {
        try {
            Permission permission = permissionRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.PERMISSION_NOT_FOUND + id));
            permissionRepository.delete(String.valueOf(permission.getId()));
        } catch (IllegalArgumentException iae) {
            throw new BadRequestException(ErrorMessages.INVALID_UUID + id);
        }
    }

    /**
     * Creates multiple permissions.
     *
     * @param permissionCreateRequests A list of PermissionCreateRequest objects representing the permissions to be created.
     * @return A list of PermissionResponse objects representing the created permissions.
     */
    @Override
    public List<PermissionResponse> createPermissions(List<PermissionCreateRequest> permissionCreateRequests) {
        List<Permission> permissions = permissionCreateRequests.stream().map(PermissionMapper::toEntity).toList();
        permissions = permissionRepository.saveAll(permissions);
        return permissions.stream().map(PermissionMapper::toResponse).toList();
    }

}
