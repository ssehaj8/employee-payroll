package com.bridgelabz.employee_payroll.dto;
//A DTO (Data Transfer Object) is a simple Java object used to transfer data between layers of an application — especially between the controller and model layers or from the client to the backend.

public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data){
        this.message=message;
        this.data= data;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public Object getData(){
        return data;
    }
    public void setData(Object data){
        this.data=data;
    }
}
