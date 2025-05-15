package dev.sathyamolagoda.book_service.dto.request;

import dev.sathyamolagoda.book_service.dto.base.AuthorBase;

import java.time.LocalDateTime;

public class AuthorCreateRequest extends AuthorBase {

    private String createdBy;
    private LocalDateTime createdAt;

}
