package net.crud.springartifact.controller;

import net.crud.springartifact.exception.ResourceNotFoundException;
import net.crud.springartifact.model.Employee;
import net.crud.springartifact.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //Rest api for fetching each employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with "+id));
        return ResponseEntity.ok(employee);
    }

    //Rest api to update individual employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable long id, @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with "+ id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) throws ResourceNotFoundException {
        Employee delEmp = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with "+id));

        employeeRepository.delete(delEmp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
