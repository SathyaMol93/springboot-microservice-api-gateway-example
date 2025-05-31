package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * This class represents the request object for updating an Author.
 * It extends the AuthorBase class and adds a field for tracking the last updated by XXXX.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorUpdateRequest extends AuthorBase {

    private String lastUpdatedBy;

}
