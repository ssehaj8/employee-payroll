package com.bridgelabz.employee_payroll.dto;

import com.bridgelabz.employee_payroll.model.Employee;
import jakarta.persistence.Entity;
import lombok.*;


//Lombok is an annotation processor - it has full access to the generated source tree.
// While annotation processors usually generate new source files, Lombok modifies existing Class by adding new fields or methods.
// Lombok generates the code at Source Time. So .class file will have the additional compiled code.

@NoArgsConstructor
@Getter
@Setter
public @Data class ResponseDto<S,S1> {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message=message;
        this.data=data;
    }
}