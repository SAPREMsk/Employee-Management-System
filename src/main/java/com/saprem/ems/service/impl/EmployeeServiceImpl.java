package com.saprem.ems.service.impl;

import com.saprem.ems.dto.EmployeeDto;
import com.saprem.ems.entity.Employee;
import com.saprem.ems.mapper.EmployeeMapper;
import com.saprem.ems.repository.EmployeeRepository;
import com.saprem.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

       Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee= employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(savedEmployee);


    }
}
