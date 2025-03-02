package com.course.courseservice.courseservice.exceptions.customexception;

public class ModuleNotFoundException extends RuntimeException{
    public ModuleNotFoundException(String message){
        super(message);
    }
}
