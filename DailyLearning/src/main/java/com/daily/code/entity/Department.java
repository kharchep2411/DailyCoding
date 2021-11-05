package com.daily.code.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="department")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Department
{
   @Id
   @GeneratedValue(strategy= GenerationType.AUTO)
  // @SequenceGenerator(initialValue = 1,name = "dept_seq",sequenceName="dept_sequence")
   @Column(name="id")
    private long id;

    @Column(name="department_name")
    private String dept_name;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();


    public Department(String dept_name)
    {
        this.dept_name = dept_name;
    }
}
