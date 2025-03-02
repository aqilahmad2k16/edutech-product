package com.course.courseservice.courseservice.exceptions.customexception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
