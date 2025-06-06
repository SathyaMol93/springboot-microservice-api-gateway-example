package dev.sathyamolagoda.user_service.dto.response;

import dev.sathyamolagoda.user_service.dto.base.UserBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * This class represents the response object for a User.
 * It extends the UserBase class and adds additional fields for tracking
 * the creation and last update details of the User.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserResponse extends UserBase {
    private UUID id;
    private String email;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
