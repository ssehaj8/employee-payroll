package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-payroll-service")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /*
    Get all employee payroll data.
    @return ResponseEntity containing a list of all employees and a success message.
    */

    @RequestMapping(value = {"", "/", "/home"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        List<Employee> empDataList=null;
        empDataList=employeePayrollService.getEmployeePayrollData();
        ResponseDto respDto=new ResponseDto("Get call success", empDataList);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

    /*
    Get employee payroll data by employee ID.
    @param employeeId - ID of the employee.
    @return ResponseEntity containing employee data for the given ID and a success message.
    */

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("employeeId") long employeeId){
        Employee empData=null;
        empData=employeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDto respDto=new ResponseDto("Get call for ID success", empData);
        return new ResponseEntity<ResponseDto>( respDto,HttpStatus.OK);
    }

    /*
    Get employees by department name.
    @param department - Department name to filter employees.
    @return ResponseEntity containing a list of employees in the specified department.
    */

    @PutMapping("/department/{department}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("department") String department){
        List<Employee> employeeList=null;
        employeeList=employeePayrollService.getEmployeesByDepartment(department);
        ResponseDto respDto=new ResponseDto("Get call for department successful : ", employeeList);
        return new ResponseEntity<ResponseDto>( respDto,HttpStatus.OK);
    }

    /*
    Add a new employee to the payroll system.
    @param employeeDTO - DTO containing new employee details.
    @return ResponseEntity containing the newly added employee and a success message.
    */

    @PostMapping("/post")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=employeePayrollService.addEmployeePayrollData(employeeDTO);
        ResponseDto respDto=new ResponseDto("Created new employee payroll data successfully ", empData);
        return new ResponseEntity<ResponseDto>( respDto,HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeeDTO employeeDTO){
//        Employee empData=null;
//        empData=employeePayrollService.updateEmployeePayrollData(employeeDTO);
//        ResponseDTO respDTO=new ResponseDTO("Updated employee payroll data successfully: ", empData);
//        return new ResponseEntity<ResponseDTO>( respDTO,HttpStatus.OK);
//    }


    /*
    Update an existing employee's data by ID.
    @param employeeId - ID of the employee to be updated.
    @param employeeDTO - DTO containing updated employee information.
    @return ResponseEntity containing updated employee data and a success message.
    */

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("employeeId") long employeeId,@RequestBody EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=employeePayrollService.updateEmployeePayrollDataById(employeeId, employeeDTO);
        ResponseDto respDTO=new ResponseDto("Updated employee payroll data successfully: ", empData);
        return new ResponseEntity<ResponseDto>( respDTO,HttpStatus.OK);
    }


      /*
    Delete an employee's payroll data by ID.
    @param employeeId - ID of the employee to be deleted.
    @return ResponseEntity confirming the deletion with the ID of the deleted employee.
    */

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("employeeId") long employeeId){
        employeePayrollService.deleteEmployeePayrollData(employeeId);
        ResponseDto respDto=new ResponseDto("Deleted successfully", "Deleted Id: "+ employeeId);
        return new ResponseEntity<ResponseDto>(respDto, HttpStatus.OK);
    }

}