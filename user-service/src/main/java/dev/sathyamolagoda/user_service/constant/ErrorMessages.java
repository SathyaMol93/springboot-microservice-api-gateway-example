package dev.sathyamolagoda.user_service.constant;

public class ErrorMessages {

    // Common
    public static final String INVALID_UUID = "Invalid UUID format: %s";

    // Role
    public static final String ROLE_NOT_FOUND = "Role not found with ID: %s";


    // Permission
    public static final String PERMISSION_NOT_FOUND = "Permission not found with ID: %s";

    // User
    public static final String USER_NOT_FOUND = "User not found with ID: %s";

    private ErrorMessages() {
        // Prevent instantiation
    }
}
