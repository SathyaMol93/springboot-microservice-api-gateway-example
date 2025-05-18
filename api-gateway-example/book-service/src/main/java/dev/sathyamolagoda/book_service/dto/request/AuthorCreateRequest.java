package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorCreateRequest extends AuthorBase {

    private String createdBy;

}
