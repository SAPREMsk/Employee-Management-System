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
        Employee employee=new Employee();

    employee.setFirstName(employeeDto.getFirstName());
    employee.setLastName(employeeDto.getLastName());
    employee.setEmail(employeeDto.getEmail());
    employee.setPhoneNo(employeeDto.getPhoneNo());

    return employee;
    }
}


