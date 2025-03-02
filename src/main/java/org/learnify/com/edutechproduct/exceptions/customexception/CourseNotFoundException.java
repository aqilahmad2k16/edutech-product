package com.course.courseservice.courseservice.exceptions.customexception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String message){
        super(message);
    }
}
