package dev.sathyamolagoda.book_service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class Base extends Auditable{

    private UUID id;

}
