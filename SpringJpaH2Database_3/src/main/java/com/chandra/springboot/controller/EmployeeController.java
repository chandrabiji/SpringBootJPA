package com.chandra.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandra.springboot.entity.Employee;
import com.chandra.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;

	// creating new Employee
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}

	// to get all employees
	public List<Employee> getAllEmployee() {
		return (List<Employee>) repo.findAll();
	}
    //to get particular employee information
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Optional<Employee> dbEmployee = repo.findById(id);
		if (dbEmployee.isPresent())
			return dbEmployee.get();
		return null;
	}
    //to update employee data
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
   //to delete particular employee id
	@DeleteMapping("/employee/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		repo.deleteById(id);
		return getEmployeeById(id);
	}

}
