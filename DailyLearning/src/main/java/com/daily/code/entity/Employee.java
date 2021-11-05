package com.daily.code.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="employee")

public class Employee
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@SequenceGenerator(initialValue = 1,name = "emp_seq",sequenceName="employee_sequence")
	private long id;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Column(name="city")
	private String city;
	
	@Column(name="gender")
	private String gender;

	@CreationTimestamp
	@Column(name="created_on", updatable = false)
	private Date insrt_date;

	@LastModifiedDate
	@Column(name="updated_on")
	private Date updt_date;

	@PrePersist
	protected void create()
	{
		insrt_date=new Date();
		updt_date=new Date();
	}

	@PreUpdate
	protected void update()
	{
		updt_date=new Date();
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName ="id", name="dept_id")
	private Department department;

}
