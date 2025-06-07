package dev.sathyamolagoda.user_service.dto.response;

import dev.sathyamolagoda.user_service.dto.base.RoleBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


/**
 * This class represents the response object for a role.
 * It extends the RoleBase class and adds additional fields for tracking
 * the creation and last update details of the Role.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleResponse extends RoleBase {

    private UUID id;
    private String name;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
