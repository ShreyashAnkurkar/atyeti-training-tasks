package com.atyeti.employeemgmt.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProjectNotFoundException extends RuntimeException{
    public ProjectNotFoundException(String msg){
        super(msg);
    }
}
