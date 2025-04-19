package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayrollDataById(long employeeId);
    Employee addEmployeePayrollData(EmployeeDTO employeeDTO);
    //Employee updateEmployeePayrollData(EmployeeDTO employeeDTO);
    void deleteEmployeePayrollData(long employeeId);

    Employee updateEmployeePayrollDataById(long employeeId, EmployeeDTO employeeDTO);
    List<Employee> getEmployeesByDepartment(String department);
}