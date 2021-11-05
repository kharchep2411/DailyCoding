package com.daily.code.controller;

import com.daily.code.entity.Employee;
import com.daily.code.request.DepartmentRequest;
import com.daily.code.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class DepartmentController
{
    @Autowired
   private DepartmentService departmentService;

    @PostMapping(value = "/addDepartment")
    public void getListOfDepartment(@RequestBody DepartmentRequest departmentRequest)
    {
        System.out.println("Inside getListOfDepartment >> ");
        departmentService.saveDepartmentData(departmentRequest);

    }

}
