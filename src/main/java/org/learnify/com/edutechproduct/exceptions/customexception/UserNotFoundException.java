package org.learnify.com.edutechproduct.exceptions.customexception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
