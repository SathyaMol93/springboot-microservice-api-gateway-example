package dev.sathyamolagoda.user_service.dto.base;

import lombok.Data;

import java.util.List;

/**
 * This class represents the base class for a role DTO.
* It contains common properties shared by different types of role DTOs.
*/
@Data
public class RoleBase {

    private String description;
    private List<String> permissionIds;

}
