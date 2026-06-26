package com.atyeti.readers;

import com.atyeti.entity.Address;
import com.atyeti.entity.Department;
import com.atyeti.entity.Employee;
import com.atyeti.exception.InvalidInputException;

import java.util.Scanner;

public class EmployeeReader {
    public static Employee readEmployee(Scanner sc) throws InvalidInputException {

        IO.println("Enter Employee Name:");
        String name = sc.nextLine().trim();

        if (name.isEmpty())
            throw new InvalidInputException("Employee Name cannot be empty");

        IO.println("Enter Employee Address Details:");
        Address address = AddressReader.readAddress(sc);

        IO.println("Enter Department Details:");
        Department department = DepartmentReader.readDepartment(sc);

        return new Employee(name, address, department);
    }
}
