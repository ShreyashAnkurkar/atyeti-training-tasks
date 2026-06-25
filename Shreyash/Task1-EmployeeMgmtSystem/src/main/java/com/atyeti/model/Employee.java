package com.atyeti.model;

import java.util.Objects;
import java.util.Random;

public class Employee {

    private  static final Random r=new Random();

    private int id=r.nextInt(1000);
    private String name;
    private Address address;
    private Department dept;

    public Employee(String name, Address address, Department dept) {
        this.name = name;
        this.address = address;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;

        if(o==null || this.getClass()!=o.getClass()) return false;

        Employee that=(Employee)o;

        return this.id==that.getId();
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", dept=" + dept +
                '}';
    }
}
