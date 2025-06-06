package dev.sathyamolagoda.user_service.dto.update;

import dev.sathyamolagoda.user_service.dto.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the request object for updating a User.
 * It extends the UserBase class and adds a field for tracking the last updated by.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserUpdateRequest extends UserBase {

    private String lastUpdatedBy;

}
