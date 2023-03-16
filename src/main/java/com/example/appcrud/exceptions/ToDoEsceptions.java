package com.example.appcrud.exceptions;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ToDoEsceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ToDoEsceptions(String message, HttpStatus httpStatus ) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
