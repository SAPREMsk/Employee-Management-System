package com.saprem.ems.service.impl;

import com.saprem.ems.dto.EmployeeDto;
import com.saprem.ems.entity.Employee;
import com.saprem.ems.exception.ResourceNotFoundException;
import com.saprem.ems.mapper.EmployeeMapper;
import com.saprem.ems.repository.EmployeeRepository;
import com.saprem.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {

   Employee newemp = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee does not exsists"+employeeId));

        return EmployeeMapper.mapToEmployeeDto(newemp);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> getAllEmp = employeeRepository.findAll();

        return getAllEmp.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee) ).collect(Collectors.toList());

    }


    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEMP) {

        Employee employee= employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employee does not exists"+employeeId));

        employee.setFirstName(updateEMP.getFirstName());
        employee.setLastName(updateEMP.getLastName());
        employee.setEmail(updateEMP.getEmail());
        employee.setPhoneNo(updateEMP.getPhoneNo());

        Employee updatedEMP= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEMP);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee does not exsists"+ employeeId));

        employeeRepository.deleteById(employeeId);
    }


}
