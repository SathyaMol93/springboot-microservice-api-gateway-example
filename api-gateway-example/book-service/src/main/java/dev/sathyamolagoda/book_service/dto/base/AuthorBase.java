package dev.sathyamolagoda.book_service.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public abstract class AuthorBase {

    private String name;
    private String country;
    private String birthDate;
    private String deathDate;
    private String biography;

}
