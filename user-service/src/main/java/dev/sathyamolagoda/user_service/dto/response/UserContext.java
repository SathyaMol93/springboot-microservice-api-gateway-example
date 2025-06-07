package dev.sathyamolagoda.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserContext {

    private UUID id;
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String avatar;
    private List<RoleResponse> roles;
    private List<PermissionResponse> permissions;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
