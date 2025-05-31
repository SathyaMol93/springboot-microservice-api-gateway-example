package dev.sathyamolagoda.book_service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

/**
 * This class represents a base entity.
 * It extends the Auditable class and includes an id field.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Base extends Auditable{

    private UUID id;

}
