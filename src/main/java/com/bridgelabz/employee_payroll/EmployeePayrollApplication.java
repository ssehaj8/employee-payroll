package com.bridgelabz.employee_payroll;

import lombok.extern.slf4j.Slf4j;
//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(EmployeePayrollApplication.class, args);

		//SpringApplication.run(EmployeePayrollApplication.class, args);
		log.info("Employee Payroll app Started in {} Enviorment", context.getEnvironment().getProperty("enviroment"));
		log.info("Employee payroll DB User is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
