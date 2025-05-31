package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * This class represents a request for creating an author.
 * It extends the AuthorBase class and adds a createdBy field.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorCreateRequest extends AuthorBase {

    private String createdBy;

}
