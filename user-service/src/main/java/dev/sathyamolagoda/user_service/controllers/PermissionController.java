package dev.sathyamolagoda.user_service.controllers;

import dev.sathyamolagoda.user_service.dto.request.PermissionCreateRequest;
import dev.sathyamolagoda.user_service.dto.response.PermissionResponse;
import dev.sathyamolagoda.user_service.dto.update.PermissionUpdateRequest;
import dev.sathyamolagoda.user_service.services.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is a REST controller that handles HTTP requests related to permissions.
 * It provides endpoints for creating, retrieving, updating, and deleting permissions.
 */
@RestController
@RequestMapping("/api/v1/permissions")
@AllArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    /**
     * Retrieves a list of all permissions.
     * GET /api/v1/permissions
     *
     * @return ResponseEntity containing a list of PermissionResponse objects
     */
    @GetMapping()
    public ResponseEntity<List<PermissionResponse>> getAllPermissions() {
        return ResponseEntity.ok(permissionService.getAllPermissions());
    }

    /**
     * Retrieves a permission by its ID.
     * GET /api/v1/permissions/{id}
     *
     * @param id The ID of the permission to retrieve.
     * @return ResponseEntity containing the PermissionResponse object
     */
    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponse> getPermissionById(@PathVariable String id) {
        return ResponseEntity.ok(permissionService.getPermissionById(id));
    }

    /**
     * Creates a new permission.
     * POST /api/v1/permissions
     *
     * @param permissionCreateRequest The request object containing the details of the permission to be created.
     * @return ResponseEntity containing the created PermissionResponse object
     */
    @PostMapping()
    public ResponseEntity<PermissionResponse> createPermission(@RequestBody PermissionCreateRequest permissionCreateRequest) {
        return ResponseEntity.ok(permissionService.createPermission(permissionCreateRequest));
    }

    @PostMapping()
    public ResponseEntity<List<PermissionResponse>> createPermissions(@RequestBody List<PermissionCreateRequest> permissionCreateRequests) {
        return ResponseEntity.ok(permissionService.createPermissions(permissionCreateRequests));
    }

    /**
     * Updates an existing per


    /**
     * Updates an existing permission.
     * PUT /api/v1/permissions/{id}
     *
     * @param id                      The ID of the permission to update.
     * @param permissionUpdateRequest The request object containing the updated details of the permission.
     * @return ResponseEntity containing the updated PermissionResponse object
     */
    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponse> updatePermission(@PathVariable Long id, @RequestBody PermissionUpdateRequest permissionUpdateRequest) {
        return ResponseEntity.ok(permissionService.updatePermission(id, permissionUpdateRequest));
    }

    /**
     * Deletes a permission by its ID.
     * DELETE /api/v1/permissions/{id}
     *
     * @param id The ID of the permission to delete.
     * @return ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable String id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
