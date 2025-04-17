package com.bridgelabz.employee_payroll.dto;

public class EmployeeDTO {
    private String name;
    private int salary;

    public EmployeeDTO(String name, int salary){
        this.salary=salary;
        this.name=name;
    }
    public int getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }
    public void setName(String name){
        this.name=name;
    }
    public String toString(){
        return "Employee{" + "name='" + name + '\'' +", salary=" + salary + '}';
    }
}
