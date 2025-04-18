package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.model.Employee;
import com.bridgelabz.employee_payroll.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;


    @RequestMapping(value = {"", "/", "/home"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        List<Employee> empDataList=null;
        empDataList=employeePayrollService.getEmployeePayrollData();
        ResponseDto respDTO=new ResponseDto("Get call success", empDataList);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("employeeId") long employeeId){
        Employee empData=null;
        empData=employeePayrollService.getEmployeePayrollDataById(employeeId);
        ResponseDto respDTO=new ResponseDto("Get call for ID success", empData);
        return new ResponseEntity<ResponseDto>( respDTO,HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=employeePayrollService.addEmployeePayrollData(employeeDTO);
        ResponseDto respDTO=new ResponseDto("Created new employee payroll data successfully ", empData);
        return new ResponseEntity<ResponseDto>( respDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@RequestBody EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=employeePayrollService.updateEmployeePayrollData(employeeDTO);
        ResponseDto respDTO=new ResponseDto("Updated employee payroll data successfully: ", empData);
        return new ResponseEntity<ResponseDto>( respDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{employeeId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@PathVariable("employeeId") long employeeId,@RequestBody EmployeeDTO employeeDTO){
        Employee empData=null;
        empData=employeePayrollService.updateEmployeePayrollDataById(employeeId, employeeDTO);
        ResponseDto respDTO=new ResponseDto("Updated employee payroll data successfully: ", empData);
        return new ResponseEntity<ResponseDto>( respDTO,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("employeeId") long employeeId){
        employeePayrollService.deleteEmployeePayrollData(employeeId);
        ResponseDto respDTO=new ResponseDto("Deleted successfully", "Deleted Id: "+ employeeId);
        return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
    }

}