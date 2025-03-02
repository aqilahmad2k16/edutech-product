package org.learnify.com.edutechproduct.exceptions.customexception;

public class CourseIsAlreadyExistException extends Exception{
    public CourseIsAlreadyExistException(String message){
        super(message);
    }
}
