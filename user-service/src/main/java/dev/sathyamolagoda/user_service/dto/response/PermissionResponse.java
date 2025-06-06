package dev.sathyamolagoda.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * This class represents the response object for a permission.
 * It adds additional fields for tracking the creation and last update details of the Author.
 */
@Data
@AllArgsConstructor
public class PermissionResponse {

    private UUID id;
    private String name;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
