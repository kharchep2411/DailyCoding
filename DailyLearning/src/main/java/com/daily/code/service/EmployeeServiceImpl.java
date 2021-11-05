package com.daily.code.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Root;

import com.daily.code.entity.Department;
import com.daily.code.repository.DepartmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.daily.code.entity.Employee;
import com.daily.code.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EntityManager em;

    @Override
    public void addEmployees() {


    }

    @Override
    public List<Employee> getListOfEmployees() {

        System.out.println("Inside Employee Service");

        List<Employee> out = new ArrayList<Employee>();

        employeeRepository.findAll().forEach(out::add);

        return out;

    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp;
    }

    @Override
    public void addEmployee(Employee emp) {
        employeeRepository.save(emp);

    }

    @Override
    public List<Employee> getEmployeeWithSameCity(String input) {

        List<Employee> sameCity = employeeRepository.getEmployeeWithSameCity(input);

        return sameCity;
    }

    @Override
    public List<Employee> getEmployeeList() {
        // TODO Auto-generated method stub

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery cq;
        Root root;

        cq = cb.createQuery(Employee.class);
        root = cq.from(Employee.class);
        List<String> predicates = new ArrayList<>();
        CriteriaQuery abc = cq.select(root.get("department")).distinct(true);
        return em.createQuery(abc).getResultList();


        //return null;
    }

    @Override
    public Employee updateEmployeeInfo(long id, Employee employee) {
        Employee empObject = employeeRepository.findById(id).get();
        Long deptId = empObject.getDepartment().getId();

       Department department = departmentRepository.findById(deptId).get();

        System.out.println("Department >>>>>>>>> " + department);

        if(null!=employee.getFname())
        {
            empObject.setFname(employee.getFname());
        }
        if(null!=employee.getLname())
        {
            empObject.setLname(employee.getLname());
        }
        if(null!=employee.getCity())
        {
            empObject.setCity(employee.getCity());
        }
        if(null!=employee.getGender())
        {
            empObject.setGender(employee.getGender());
        }

        if(null!=employee.getDepartment())
        {
            department.setDept_name(employee.getDepartment().getDept_name());
        }

        departmentRepository.save(department);

        System.out.println("Employee update object" + empObject);

        return employeeRepository.save(empObject);

    }


}
