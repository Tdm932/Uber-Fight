package com.its.projectjava.exception;

public class LoginAlreadyExistsException extends Exception{
    public LoginAlreadyExistsException(){
        super("This login is already used by another user");
    }
}
