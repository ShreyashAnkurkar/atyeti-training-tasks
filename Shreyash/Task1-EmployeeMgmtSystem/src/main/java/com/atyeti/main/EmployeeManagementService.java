package com.atyeti.main;
import com.atyeti.model.Address;
import com.atyeti.model.Department;
import com.atyeti.model.Employee;
import com.atyeti.service.EmployeeServiceImpl;
import com.atyeti.service.IEmployeeService;

import java.util.List;
import java.util.Scanner;
public class EmployeeManagementService {

    private static final IEmployeeService es=new EmployeeServiceImpl();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);



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
            switch(choice){
                case 1 ->{
                    IO.println("Enter How many employees you want to add: ");
                    int num=sc.nextInt();
                    sc.nextLine();
                    for(int i=1;i<=num;i++){
                        IO.println("Enter employee Name for emp : "+i);
                        String name=sc.nextLine();
                        IO.println("Enter Employee Address Details: ");

                        //Address details
                        IO.println("Enter House Number:");
                        String houseNo = sc.nextLine();

                        IO.println("Enter Street:");
                        String street = sc.nextLine();

                        IO.println("Enter City:");
                        String city = sc.nextLine();

                        IO.println("Enter State:");
                        String state = sc.nextLine();

                        IO.println("Enter Country:");
                        String country = sc.nextLine();

                        IO.println("Enter Pincode:");
                        String pincode = sc.nextLine();

                        Address adr=new Address(houseNo,street,city,state,country,pincode);

                        IO.println("Enter department details: ");

                        //department details
                        IO.println("Enter Department ID:");
                        int deptId = sc.nextInt();
                        sc.nextLine(); // consume newline

                        IO.println("Enter Department Name:");
                        String deptName = sc.nextLine();

                        IO.println("Enter Manager Name:");
                        String managerName = sc.nextLine();

                        Department dept=new Department(deptId,deptName,managerName);

                        Employee e=new Employee(name,adr,dept);

                        if(es.addEmployee(e))IO.println("Data for employee "+i+" added");
                        else IO.println("invalid Employee data try again");

                    }
                }

                case 2->{
                    IO.println("Enter employee's id for data modification: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    IO.println("Enter employee Name: ");
                    String name=sc.nextLine();
                    IO.println("Enter Employee Address Details: ");

                    //Address details
                    IO.println("Enter House Number:");
                    String houseNo = sc.nextLine();

                    IO.println("Enter Street:");
                    String street = sc.nextLine();

                    IO.println("Enter City:");
                    String city = sc.nextLine();

                    IO.println("Enter State:");
                    String state = sc.nextLine();

                    IO.println("Enter Country:");
                    String country = sc.nextLine();

                    IO.println("Enter Pincode:");
                    String pincode = sc.nextLine();

                    Address adr=new Address(houseNo,street,city,state,country,pincode);

                    IO.println("Enter department details: ");

                    //department details
                    IO.println("Enter Department ID:");
                    int deptId = sc.nextInt();
                    sc.nextLine(); // consume newline

                    IO.println("Enter Department Name:");
                    String deptName = sc.nextLine();

                    IO.println("Enter Manager Name:");
                    String managerName = sc.nextLine();

                    Department dept=new Department(deptId,deptName,managerName);

                    Employee e=new Employee(name,adr,dept);

                    if(es.updateEmployee(id,e))IO.println("Employee data updated");
                    else IO.println("invalid Employee data try again");
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

                    Employee e=es.searchEmployeeById(id);
                    if(e!=null) IO.println(e);
                    else IO.println("Employee not found...");

                }

                case 5->{
                    List<Employee> l=es.displayAllEmployees();
                    l.forEach(IO::println);
                }
                case 6->{
                    c=false;
                    IO.println("Exiting application....");
                }
            }
        }





    }
}
