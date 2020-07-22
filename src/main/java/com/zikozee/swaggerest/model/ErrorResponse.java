package com.zikozee.swaggerest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")

@Data
public class ErrorResponse {

    //General error message about nature of error
    private String message;

    //Specific errors in API request processing
    private String details;

    //Getter and setters
    public ErrorResponse(String message, String details) {
        super();
        this.message = message;
        this.details = details;
    }

}