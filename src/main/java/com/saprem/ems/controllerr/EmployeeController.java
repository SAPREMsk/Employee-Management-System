package com.saprem.ems.controllerr;

import com.saprem.ems.dto.EmployeeDto;
import com.saprem.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId,
                                                       @RequestBody EmployeeDto updatedEmployee){

        EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){

        EmployeeDto getEm = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(getEm);
    }

    @GetMapping
    public ResponseEntity< List<EmployeeDto>>  getAllEmployees(){
        List<EmployeeDto> allemp = employeeService.getAllEmployees();
    return ResponseEntity.ok(allemp);
    }
    
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employee,
                                                      @RequestBody EmployeeDto updateEMP){
        EmployeeDto employeeDto= employeeService.updateEmployee(employee,updateEMP);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long delEmployeeId){
        employeeService.deleteEmployee(delEmployeeId);
        return ResponseEntity.ok("employee deleted succefully "+delEmployeeId);
    }
}