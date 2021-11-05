package com.daily.code.request;

import com.daily.code.entity.Employee;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentRequest
{
    private String department;
    private String fname;
    private String lname;
    private String city;
    private String gender;

}
