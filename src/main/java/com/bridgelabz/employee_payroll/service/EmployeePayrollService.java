package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.repositories.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    List<Employee> employeeList=new ArrayList<>();
    public List<Employee> getEmployeePayrollData(){
        return employeeList;
    }

    public Employee getEmployeePayrollDataById(long employeeId){
        return employeeList.get((int)employeeId-1);
    }

    public Employee addEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=new Employee(employeeList.size()+1, employeeDTO);
        employeeList.add(empData);
        return empData;
    }

    public Employee updateEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=new Employee(1,employeeDTO);
        return empData;
    }

    public Employee updateEmployeePayrollDataById(long employeeId, EmployeeDTO employeeDTO){
        Employee empData=this.getEmployeePayrollDataById(employeeId);
        empData.setName("Sehaj");
        empData.setSalary(80000);
        employeeList.add((int) (employeeId-1),empData);
        return empData;
    }

    public void deleteEmployeePayrollData(long employeeId) {
//        EmployeeRepository.deleteEmployeePayrollData(employeeId);
        employeeList.remove(employeeId-1);
    }
}