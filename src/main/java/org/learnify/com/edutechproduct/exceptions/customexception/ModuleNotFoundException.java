package org.learnify.com.edutechproduct.exceptions.customexception;

public class ModuleNotFoundException extends RuntimeException{
    public ModuleNotFoundException(String message){
        super(message);
    }
}
