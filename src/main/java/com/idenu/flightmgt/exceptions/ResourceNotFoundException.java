package com.idenu.flightmgt.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private int fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue){
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue)); //Passenger not found with id: id
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
