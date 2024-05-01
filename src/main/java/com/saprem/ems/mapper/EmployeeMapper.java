package com.saprem.ems.mapper;

import com.saprem.ems.dto.EmployeeDto;
import com.saprem.ems.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNo()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employeee=new Employee();

    employeee.setFirstName(employeeDto.getFirstName());
    employeee.setLastName(employeeDto.getLastName());
    employeee.setEmail(employeeDto.getEmail());
    employeee.setPhoneNo(employeeDto.getPhoneNo());

    return employeee;
    }
}


