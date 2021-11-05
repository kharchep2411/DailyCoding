package com.daily.code.service;

import com.daily.code.entity.Employee;
import com.daily.code.repository.DepartmentRepository;
import com.daily.code.request.DepartmentRequest;

public interface DepartmentService
{
    public Employee saveDepartmentData(DepartmentRequest departmentRequest);

    public void getDepartmentData();

}
