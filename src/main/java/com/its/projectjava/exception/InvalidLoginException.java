package com.its.projectjava.exception;

public class InvalidLoginException extends Exception{

    public InvalidLoginException(){
        super("The login must have at least 3 characters");
    }
}
