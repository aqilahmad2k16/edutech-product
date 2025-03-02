package org.learnify.com.edutechproduct.exceptions.customexception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String message){
        super(message);
    }
}
