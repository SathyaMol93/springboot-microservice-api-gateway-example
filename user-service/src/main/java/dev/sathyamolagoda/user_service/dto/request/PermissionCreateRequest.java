package dev.sathyamolagoda.user_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents a request for creating a permission.
 */
@Data
@AllArgsConstructor
public class PermissionCreateRequest {

    private String name;
    private String description;
    private String createdBy;

}
