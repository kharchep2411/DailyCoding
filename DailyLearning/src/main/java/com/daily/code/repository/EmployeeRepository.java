package com.daily.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.daily.code.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>

{

	@Query(value = "select * from Employee e where e.city= ?1", nativeQuery = true)
	List<Employee> getEmployeeWithSameCity(String input);




}
