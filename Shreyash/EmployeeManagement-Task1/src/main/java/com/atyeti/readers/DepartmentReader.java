package com.atyeti.readers;

import com.atyeti.entity.Department;
import com.atyeti.exception.InvalidInputException;

import java.util.Scanner;

public class DepartmentReader {
    public static Department readDepartment(Scanner sc) throws InvalidInputException {

        IO.println("Enter Department ID:");
        int deptId = sc.nextInt();

        if (deptId <= 0)
            throw new InvalidInputException("Department ID must be greater than 0");

        sc.nextLine();

        IO.println("Enter Department Name:");
        String deptName = sc.nextLine().trim();

        if (deptName.isEmpty())
            throw new InvalidInputException("Department Name cannot be empty");

        IO.println("Enter Manager Name:");
        String managerName = sc.nextLine().trim();

        if (managerName.isEmpty())
            throw new InvalidInputException("Manager Name cannot be empty");

        return new Department(deptId, deptName, managerName);
    }
}
