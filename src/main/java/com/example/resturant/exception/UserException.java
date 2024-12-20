package com.example.resturant.exception;

import org.springframework.stereotype.Service;

@Service
public class UserException extends Exception{

    public String name;

    public UserException(String name){
        super();
    }
    public UserException(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserException{" +
                "name='" + name + '\'' +
                '}';
    }
}
