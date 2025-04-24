package com.bridgelabz.employee_payroll.service;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.exceptions.EmployeePayrollException;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeeRepository employeeRepository;


    /*
    Fetch all employee payroll data.
    @return List of all employees.
    */
    public List<Employee> getEmployeePayrollData(){
        return employeeRepository.findAll();
    }



    /*
    Fetch employee payroll data by employee ID.
    @param employeeId - ID of the employee.
    @return Employee object if found, otherwise throws EmployeePayrollException.
    */
    public Employee getEmployeePayrollDataById(long employeeId){
        return employeeRepository
                .findById(employeeId)
                .orElseThrow(()->new EmployeePayrollException("Employee with employee id "+employeeId+" does not exist!!"));
    }


    /*
    Fetch employees by department.
    @param department - Department name.
    @return List of employees belonging to the specified department.
    */
    @Override
    public List<Employee> getEmployeesByDepartment(String department){
        return employeeRepository.findEmployeesByDepartment(department);
    }


    /*
    Add new employee payroll data.
    @param employeeDTO - Employee DTO containing new employee details.
    @return Saved Employee object.
    */
    public Employee addEmployeePayrollData(EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=new Employee(employeeDTO);
        log.debug("Emp data: "+empData.toString());

        return employeeRepository.save(empData);
    }


    /*
   Update employee payroll data by employee ID.
   @param employeeId - ID of the employee to be updated.
   @param employeeDTO - Employee DTO containing updated employee data.
   @return Updated Employee object.
   */
    public Employee updateEmployeePayrollDataById(long employeeId, EmployeeDTO employeeDTO){
        Employee empData=this.getEmployeePayrollDataById(employeeId);
        empData.updateEmployeePayrollData(employeeDTO);
        return employeeRepository.save(empData);
    }


    /*
    Delete employee payroll data by employee ID.
    @param employeeId - ID of the employee to be deleted.
    */
    public void deleteEmployeePayrollData(long employeeId) {
        Employee empData=this.getEmployeePayrollDataById(employeeId);
        employeeRepository.delete(empData);
    }
}