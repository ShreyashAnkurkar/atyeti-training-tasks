package com.atyeti.employeemgmt.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeNotFoundException extends RuntimeException{
   public EmployeeNotFoundException(String msg){
       super(msg);
   }
}
