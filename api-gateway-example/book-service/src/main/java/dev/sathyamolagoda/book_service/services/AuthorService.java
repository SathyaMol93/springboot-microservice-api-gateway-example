package dev.sathyamolagoda.book_service.services;

import dev.sathyamolagoda.book_service.dto.request.AuthorCreateRequest;
import dev.sathyamolagoda.book_service.dto.response.AuthorResponse;
import dev.sathyamolagoda.book_service.dto.update.AuthorUpdateRequest;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> findAllAuthors();

    AuthorResponse findAuthorById(String id);

    AuthorResponse createAuthor(AuthorCreateRequest authorCreateRequest);

    AuthorResponse updateAuthor(String id, AuthorUpdateRequest authorUpdateRequest);

    void deleteAuthor(String id);
}
