package com.ihub.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.ihub.www.exception.ResourceNotFoundException;
import com.ihub.www.model.Employee;
import com.ihub.www.repo.EmployeeRepository;
@Service
public class EmployeeService<HttpStatus> {
	@Autowired
	EmployeeRepository employeeRepository;
	

	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
	}


	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
	}


	public ResponseEntity<Employee> updateEmployee(int id, Employee employee) {
		
		Employee emp = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not Exist"));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		Employee updateEmp = employeeRepository.save(emp);
		return ResponseEntity.ok(updateEmp);
				
	}


	public ResponseEntity<HttpStatus> deleteEmployee(int id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee doesn't exist"));
		employeeRepository.delete(employee);
		//return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return null;
		
	}

}
