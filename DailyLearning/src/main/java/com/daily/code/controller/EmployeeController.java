package com.daily.code.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.daily.code.entity.Employee;
import com.daily.code.repository.EmployeeRepository;
import com.daily.code.service.EmployeeService;

@RestController
@RequestMapping(value = "/v1/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EmployeeController
{

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	
	
	@GetMapping(value = "/addEmployees")
	public void addEmployees()
	{
		System.out.println("Inside addEmployees >> ");
		employeeService.addEmployees();
		
	}
	
	
	@PostMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee)
	{
		System.out.println("Inside addEmployee post API >> ");
		employeeService.addEmployee(employee);
		
	}
	
	@GetMapping(value = "/getEmployees")
	public List<Employee> getListOfEmployees()
	{
		System.out.println("Inside getEmployees >> ");
		return employeeService.getListOfEmployees();
	}

	@PostMapping(value = "/updateEmployees/{id}")
	public Employee getEmployeeById(@PathVariable long id,@RequestBody Employee employee)
	{
		System.out.println("Inside getEmployees >> ");
		return employeeService.updateEmployeeInfo(id,employee);
	}

	
	@GetMapping(value = "/getEmployees/{city}")
	public List<Employee> getEmployeesWithSameCity1(@PathVariable String city)
	{

		System.out.println("/getEmployees/{city} >> ");
		return employeeService.getEmployeeWithSameCity(city);
	}

	@GetMapping(value = "/deparment")
	public List<Employee> getDeparmentsList()
	{

		System.out.println("getEmployeesList >> ");
		return employeeService.getEmployeeList();
	}


	
}
