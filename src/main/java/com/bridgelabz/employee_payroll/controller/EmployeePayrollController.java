package com.bridgelabz.employee_payroll.controller;

import com.bridgelabz.employee_payroll.dto.EmployeeDTO;
import com.bridgelabz.employee_payroll.dto.ResponseDto;
import com.bridgelabz.employee_payroll.model.Employee;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.apache.el.util.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value={"","/","/get"})
    public ResponseEntity<ResponseDto> getEmployeePayrollData(){
        Employee employee= null;
        employee= new Employee(1, new EmployeeDTO("Sehaj", 80000));
        ResponseDto responseDto= new ResponseDto("Get Call Success", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @GetMapping("/get/{employeeId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("employeeId") int employeeId){
        Employee employee= null;
        employee= new Employee(1, new EmployeeDTO("Sehaj", 80000));
        ResponseDto responseDto= new ResponseDto("Get Call Success for id:", employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeeDTO employeePayrollDTO) {
        Employee employee= null;
        employee= new Employee(1, employeePayrollDTO);
        ResponseDto responseDto= new ResponseDto("Created Employee Payroll Data Successfully",employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(@RequestBody EmployeeDTO employeePayrollDTO){
        Employee employee= null;
        employee= new Employee(1, employeePayrollDTO);
        ResponseDto responseDto= new ResponseDto("Updated Employee Payroll Data Successfully",employee);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("employeeId") int employeeId){
        ResponseDto responseDto= new ResponseDto("Deleted Successfully","Deleted id: "+employeeId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
