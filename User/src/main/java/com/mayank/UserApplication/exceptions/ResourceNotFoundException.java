package com.mayank.UserApplication.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not Found on Server");
    }

    public ResourceNotFoundException(String mess){
        super(mess);
    }
}
