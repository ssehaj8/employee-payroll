package com.bridgelabz.employee_payroll.model;


import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    private String name;
    private int salary;

    //setters
    public void setEmployeeId(long employeeId){
        this.employeeId=employeeId;
    }
    public void setName(String name){
        this.name= name;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

    //getters
    public long getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public int getSalary(){
        return salary;
    }
    //default constructor
    public Employee(){}

    //parametrized constructors are used when we need to add coustom values
    public Employee(long employeeId, EmployeeDTO employeeDTO){
        this.employeeId=employeeId;
        this.name=employeeDTO.getName();
        this.salary=employeeDTO.getSalary();
    }

}
