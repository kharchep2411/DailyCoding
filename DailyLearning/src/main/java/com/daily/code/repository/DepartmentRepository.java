package com.daily.code.repository;

import com.daily.code.entity.Department;
import com.daily.code.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>
{
}
