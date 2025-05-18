package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthorUpdateRequest extends AuthorBase {

    private String lastUpdatedBy;

}
