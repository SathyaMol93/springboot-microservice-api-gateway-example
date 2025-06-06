package dev.sathyamolagoda.user_service.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the request object for updating a Permission.
 * It extends the PermissionBase class and adds a field for tracking the last updated by.
 */
@Data
@AllArgsConstructor
public class PermissionUpdateRequest {

    private String name;
    private String description;
    private String lastUpdatedBy;

}
