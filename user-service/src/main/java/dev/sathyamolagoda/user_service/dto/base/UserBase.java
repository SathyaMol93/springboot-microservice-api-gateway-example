package dev.sathyamolagoda.user_service.dto.base;

import lombok.Data;

import java.util.List;

/**
 * This class represents the base class for a user DTO.
 * It contains common properties shared by different types of user DTOs.
 */
@Data
public class UserBase {
    private String username;
    private String fullName;
    private String phone;
    private String avatar;
    private List<String> roleIds;

}
