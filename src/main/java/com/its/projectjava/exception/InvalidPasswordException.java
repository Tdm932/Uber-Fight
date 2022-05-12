package com.its.projectjava.exception;

public class InvalidPasswordException extends Exception{

    public InvalidPasswordException(){
        super("The password must have at least 3 characters");
    }
}
