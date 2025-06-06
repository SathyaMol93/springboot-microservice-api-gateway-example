package dev.sathyamolagoda.user_service.dto.update;

import dev.sathyamolagoda.user_service.dto.base.RoleBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the request object for updating a Role.
 * It extends the RoleBase class and adds a field for tracking the last updated by.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RoleUpdateRequest extends RoleBase {

    private String lastUpdatedBy;

}
