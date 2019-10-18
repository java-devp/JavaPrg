package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

import lombok.Data;

@Data
@Entity
//@SQLDelete(sql ="UPDATE Employee_Details_jpa SET active = true WHERE empno = ?")

//@Where(clause ="active=1")
@Table(name="Employee_Details_jpa")
public class EmployeeEntity {
	@Id
	//@GeneratedValue
	@Column(name="empno" , length=4)
	
	private int empno;
	
	@Column(name="ename",length=15)
	private String ename;
	
	@Column(name="email" ,length=20)
	private String email;
	
	@Column(name="password" ,length=10)
	private String password;
	
	@Column(name="active",length=12)
	private boolean active;
	

}
