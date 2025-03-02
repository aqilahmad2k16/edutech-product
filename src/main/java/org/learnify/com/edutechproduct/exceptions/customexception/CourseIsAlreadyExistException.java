package com.course.courseservice.courseservice.exceptions.customexception;

public class CourseIsAlreadyExistException extends Exception{
    public CourseIsAlreadyExistException(String message){
        super(message);
    }
}
