package com.pranay.runner;

import com.pranay.dto.EmployeeDto;
import com.pranay.entity.Employee;
import com.pranay.exception.EmployeeNotFoundException;
import com.pranay.exception.InvalidDataException;
import com.pranay.service.IEmployeeService;
import com.pranay.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

public class EmployeeRunner {
    private IEmployeeService service;

    void main() {
        service = new EmployeeServiceImpl();

        while (true){
            IO.println("================ Employee Management System ==============");
            IO.println("1] Add Employee Data");
            IO.println("2] Update Employee Data");
            IO.println("3] Delete Employee Data");
            IO.println("4] Search Employee By Id");
            IO.println("5] Show All Employees Data");
            IO.println("6] Exit\n");

            int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

            switch (choice){
                case 1 -> {
                    String name = IO.readln("Enter Employee Name : ");
                    String designation = IO.readln("Enter Employee Designation : ");
                    Double salary = Double.valueOf(IO.readln("Enter Your Salary : "));

                    Employee employee = new Employee(name,designation,salary);

                    String res = service.addEmployee(employee);
                    IO.println(res);
                }

                case 2 -> {
                    Integer id = Integer.valueOf(IO.readln("Enter Employee Id to Update the existing details : "));
                    String designation = IO.readln("Enter Employee Designation : ");
                    Double salary = Double.valueOf(IO.readln("Enter Your Salary : "));
                    EmployeeDto dto = new EmployeeDto(id,designation,salary);

                    try{
                        String res = service.updateEmployee(dto);
                        IO.println(res);
                    }catch (EmployeeNotFoundException | InvalidDataException e){
                        IO.println(e.getMessage());
                    }
                }

                case 3 -> {
                    Integer id = Integer.valueOf(IO.readln("Enter Employee Id to delete record : "));

                    try{
                        String res = service.deleteEmployee(id);
                        IO.println(res);
                    }catch (EmployeeNotFoundException | InvalidDataException e){
                        IO.println(e.getMessage());
                    }
                }

                case 4 -> {
                    Integer id = Integer.valueOf(IO.readln("Enter Employee Id to search : "));

                    try{
                        Optional<Employee> emp = service.searchEmployeeById(id);
                        IO.println("==== Employee Details ====");

                        emp.ifPresent(IO::println);
                    }catch (EmployeeNotFoundException | InvalidDataException e){
                        IO.println(e.getMessage());
                    }
                }

                case 5 -> {
                    List<Employee> employeeList = service.displayAllEmployees();
                    employeeList.forEach(IO::println);
                }

                case 6 -> {
                    IO.println("Thank You!");
                    System.exit(0);
                }
            }
        }
    }
}
