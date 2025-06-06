package dev.sathyamolagoda.user_service.dto.request;

import dev.sathyamolagoda.user_service.dto.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents a request for creating a user.
 * It extends the UserBase class and adds a createdBy field.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserCreateRequest extends UserBase {

    private String email;
    private String createdBy;

}
