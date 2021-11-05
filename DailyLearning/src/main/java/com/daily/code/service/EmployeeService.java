package com.daily.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daily.code.entity.Employee;



public interface EmployeeService 
{

public void addEmployees();
void addEmployee(Employee emp);
public List<Employee> getListOfEmployees();
public Optional<Employee> getEmployeeById(long id);
public List<Employee> getEmployeeWithSameCity(String input);
public List<Employee> getEmployeeList();
public Employee updateEmployeeInfo(long id,Employee employee);


	
}
