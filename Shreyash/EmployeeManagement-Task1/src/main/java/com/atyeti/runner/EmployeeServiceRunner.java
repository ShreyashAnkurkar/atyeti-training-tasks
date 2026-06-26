package com.atyeti.runner;
import com.atyeti.entity.*;
import com.atyeti.exception.InvalidInputException;
import com.atyeti.readers.EmployeeReader;
import com.atyeti.service.Implementation.EmployeeServiceImpl;
import com.atyeti.service.Interface.IEmployeeService;

import java.util.List;
import java.util.Scanner;
public class EmployeeServiceRunner {

    private final IEmployeeService es=new EmployeeServiceImpl();

    public void run(){
        Scanner sc=new Scanner(System.in);

        try{
            boolean c=true;
            while(c){
                IO.println("""
                =====================================
                     EMPLOYEE MANAGEMENT SYSTEM
                =====================================
                1. Add Employee
                2. Update Employee
                3. Delete Employee
                4. Search Employee By ID
                5. Display All Employees
                6. Exit
                Enter Your Choice:""");

                int choice=sc.nextInt();

                if(choice<=0 || choice>6)throw new InvalidInputException("choice must be in between range 1 to 6");
                switch(choice){
                    case 1 -> {

                        IO.println("Enter number of employees:");
                        int num = sc.nextInt();

                        if (num <= 0)
                            throw new InvalidInputException("Invalid Number");

                        sc.nextLine();

                        for (int i = 1; i <= num; i++) {

                            IO.println("Employee " + i);

                            Employee employee = EmployeeReader.readEmployee(sc);

                            if (es.addEmployee(employee))
                                IO.println("Employee Added Successfully");
                            else
                                IO.println("Unable to Add Employee");
                        }
                    }

                    case 2 -> {

                        IO.println("Enter Employee ID:");
                        int id = sc.nextInt();

                        if(id <= 0)
                            throw new InvalidInputException("Invalid Employee ID");

                        sc.nextLine();

                        Employee employee = EmployeeReader.readEmployee(sc);

                        if(es.updateEmployee(id, employee))
                            IO.println("Employee Updated Successfully");
                        else
                            IO.println("Employee Not Found");
                    }
                    case 3->{
                        IO.println("Enter employee's id for deletion: ");
                        int id=sc.nextInt();
                        boolean b=es.deleteEmployee(id);
                        if(b)IO.println("Employee data delete successfully");
                        else IO.println("Data is not present try again...");
                    }

                    case 4->{
                        IO.println("Enter employee's id: ");
                        int id=sc.nextInt();
                        if(id<=0) throw new InvalidInputException("id must be greater than zero");

                        Employee e=es.searchEmployeeById(id);
                        if(e!=null) IO.println(e);
                        else IO.println("Employee not found...");

                    }

                    case 5->{
                        es.displayAllEmployees();
                    }
                    case 6->{
                        c=false;
                        IO.println("Exiting application....");
                    }
                }
            }
        } catch (Exception e) {
            IO.println(e.getMessage());
        }

    }
}
