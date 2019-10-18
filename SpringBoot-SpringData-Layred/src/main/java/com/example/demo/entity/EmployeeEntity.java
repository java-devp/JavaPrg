package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee_Details_Repo")
public class EmployeeEntity {
	@Id
	//@GeneratedValue
	@Column(name="empno")
	private int empno;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	

}
