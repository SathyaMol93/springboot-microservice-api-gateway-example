package dev.sathyamolagoda.book_service.dto.update;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;

import java.time.LocalDateTime;

public class AuthorUpdateRequest extends AuthorBase {

    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedAt;

}
