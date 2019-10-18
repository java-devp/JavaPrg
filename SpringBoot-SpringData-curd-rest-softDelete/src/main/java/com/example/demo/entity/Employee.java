package com.example.demo.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name="Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	
	
	private int empno;
	private String ename;
	private String email;
	private String password;
	private boolean active;
	

}
