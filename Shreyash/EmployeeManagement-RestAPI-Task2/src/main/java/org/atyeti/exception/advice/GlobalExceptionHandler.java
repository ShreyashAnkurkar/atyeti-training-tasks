package org.atyeti.exception.advice;

import org.atyeti.exception.DepartmentNotFoundException;
import org.atyeti.exception.DuplicateRecordException;
import org.atyeti.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ProblemDetail handleEmployeeNotFound(EmployeeNotFoundException ex) {

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problem.setTitle("Employee Not Found");
        problem.setDetail(ex.getMessage());

        return problem;
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ProblemDetail handleDepartmentNotFound(DepartmentNotFoundException ex) {

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problem.setTitle("Department Not Found");
        problem.setDetail(ex.getMessage());

        return problem;
    }

    @ExceptionHandler(DuplicateRecordException.class)
    public ProblemDetail handleDuplicateRecord(DuplicateRecordException ex) {

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        problem.setTitle("Duplicate Department");
        problem.setDetail(ex.getMessage());

        return problem;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception ex) {

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problem.setTitle("Internal Server Error");
        problem.setDetail(ex.getMessage());

        return problem;
    }
}