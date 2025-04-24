package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {


    /*
    Fetch all employee payroll data.
    @return List of all Employee objects.
    */
    List<Employee> getEmployeePayrollData();


    /*
    Fetch employee payroll data by employee ID.
    @param employeeId - ID of the employee.
    @return Employee object if found.
    */
    Employee getEmployeePayrollDataById(long employeeId);


    /*
    Add new employee payroll data.
    @param employeeDTO - DTO containing new employee details.
    @return Saved Employee object.
    */
    Employee addEmployeePayrollData(EmployeeDTO employeeDTO);
    //Employee updateEmployeePayrollData(EmployeeDTO employeeDTO);


    /*
    Delete employee payroll data by employee ID.
    @param employeeId - ID of the employee to be deleted.
    */
    void deleteEmployeePayrollData(long employeeId);


    /*
   Update employee payroll data by employee ID.
   @param employeeId - ID of the employee to be updated.
   @param employeeDTO - DTO containing updated employee data.
   @return Updated Employee object.
   */
    Employee updateEmployeePayrollDataById(long employeeId, EmployeeDTO employeeDTO);


    /*
   Update employee payroll data by employee ID.
   @param employeeId - ID of the employee to be updated.
   @param employeeDTO - DTO containing updated employee data.
   @return Updated Employee object.
   */
    List<Employee> getEmployeesByDepartment(String department);
}