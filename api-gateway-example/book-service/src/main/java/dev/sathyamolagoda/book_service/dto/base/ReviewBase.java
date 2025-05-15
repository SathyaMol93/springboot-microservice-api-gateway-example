package dev.sathyamolagoda.book_service.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public abstract class ReviewBase{

    private String review;
    private String userId;
    private String userName;
    private String userAvatar;
    private String bookId;
    private String rating;

}
