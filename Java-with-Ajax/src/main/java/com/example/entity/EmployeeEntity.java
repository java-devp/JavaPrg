package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee_Table2")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer empid;
	
	@Column(name="ename",length=10)
	private String ename;
	
	@Column(name="addrs",length=15)
	private String addrs;
	
	@Column(name="salary",length=15)
	private String salary;


}
