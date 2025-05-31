package dev.sathyamolagoda.book_service.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class represents the base class for an author DTO.
 * It contains common properties shared by different types of author DTOs.
 */
@Data
public abstract class AuthorBase {

    private String name;
    private String country;
    private String birthDate;
    private String deathDate;
    private String biography;

}
