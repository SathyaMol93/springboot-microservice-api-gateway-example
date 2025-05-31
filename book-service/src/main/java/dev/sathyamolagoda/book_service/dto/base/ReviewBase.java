package dev.sathyamolagoda.book_service.dto.base;

import lombok.Data;

/**
 * This class represents the base class for a review DTO.
 * It contains common properties shared by different types of review DTOs.
 */
@Data
public abstract class ReviewBase{

    private String review;
    private String userId;
    private String userName;
    private String userAvatar;
    private String bookId;
    private Integer rating;

}
