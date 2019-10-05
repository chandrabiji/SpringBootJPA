package com.chandra.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.chandra.springboot.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
