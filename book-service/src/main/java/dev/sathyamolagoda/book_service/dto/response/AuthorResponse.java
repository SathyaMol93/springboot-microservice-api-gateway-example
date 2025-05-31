package dev.sathyamolagoda.book_service.dto.response;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents the response object for an Author.
 * It extends the AuthorBase class and adds additional fields for tracking
 * the creation and last update details of the Author.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorResponse extends AuthorBase {

    private UUID id;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
