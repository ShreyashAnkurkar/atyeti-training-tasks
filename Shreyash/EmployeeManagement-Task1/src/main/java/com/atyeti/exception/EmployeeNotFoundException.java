package com.atyeti.exception;

public class EmployeeNotFoundException extends RuntimeException{

   public EmployeeNotFoundException(String msg){
        super(msg);
    }
   public  EmployeeNotFoundException(){}
}
