package com.daily.code.service;

import com.daily.code.entity.Department;
import com.daily.code.entity.Employee;
import com.daily.code.repository.DepartmentRepository;
import com.daily.code.repository.EmployeeRepository;
import com.daily.code.request.DepartmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Employee saveDepartmentData(DepartmentRequest departmentRequest)
    {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> departmentRequest " + departmentRequest);

        Employee employee = new Employee();
        employee.setFname(departmentRequest.getFname());
        employee.setLname(departmentRequest.getLname());
        employee.setCity(departmentRequest.getCity());
        employee.setGender(departmentRequest.getGender());

        Department department = new Department(departmentRequest.getDepartment());
        employee.setDepartment(department);
        return employeeRepository.save(employee);

        }

    @Override
    public void getDepartmentData()
    {

    }

}
