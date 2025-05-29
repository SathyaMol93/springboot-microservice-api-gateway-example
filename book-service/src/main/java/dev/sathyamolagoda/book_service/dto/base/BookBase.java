package dev.sathyamolagoda.book_service.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public abstract class BookBase{

    protected String title;
    protected String description;
    protected String publisher;
    protected String genre;
    protected String language;
    protected String format;
    protected String edition;
    protected String pageCount;
    protected String coverImage;
    protected String price;

}
