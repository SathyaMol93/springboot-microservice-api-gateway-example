package dev.sathyamolagoda.user_service.dto.request;

import dev.sathyamolagoda.user_service.dto.base.RoleBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents a request for creating an role.
 * It extends the RoleBase class and adds a createdBy field.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class RoleCreateRequest extends RoleBase {

    private String name;
    private String createdBy;

}
