package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.appcontant.AppConstant;
import com.example.demo.appproperties.AppsProps;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.Employee_DetailsRepositary;


@Controller
public class EmployeeDetailsController {
	
	@Autowired
	private AppsProps props;
	
	@Autowired
	private Employee_DetailsRepositary stdrepos;
	/*
	 * @Autowired private AppConstant appcnt;
	 */
	
	public EmployeeDetailsController() {
		System.out.println("EmployeeDetails.EmployeeDetails()");
	}
	
	@RequestMapping(value="/employee")
	public String empDetails(Model model) {
		EmployeeEntity employee= new EmployeeEntity();
		String emp= "Employee Details";
		System.out.println("Employee::"+emp);
		model.addAttribute("empmsg",employee);
		return "employee";
	}
	
	/**
	 * Method for 
	 * @param employee
	 * @param model
	 * @return
	 */
    @RequestMapping(value=AppConstant.pathName,method=RequestMethod.POST)
	public String registerEmployee(@ModelAttribute(AppConstant.employeeModelObject) Employee employee,Model model) {
    	EmployeeEntity empEntity= new EmployeeEntity();
    	EmployeeEntity entity=null;
    	//convert data to command to entity class
        BeanUtils.copyProperties(employee, empEntity);
        empEntity.setActive(true);
    	entity=stdrepos.save(empEntity);
    	
    	if(entity!=null) {
    	String appsprops=props.getMessages().get("regsuccess");
    	System.out.println(appsprops);
		model.addAttribute(AppConstant.empReg,appsprops);
    	}
    	else {
    		String appsprops=props.getMessages().get("regfailuer");
        	System.out.println(appsprops);
    		model.addAttribute(AppConstant.empReg,appsprops);
    	}
		return AppConstant.viewLogicalName;
	}
	
    // method for retrieving data from Database
    @RequestMapping(value="/empfind12")
    public String reterieveData(Model model) {
    	Iterable<EmployeeEntity> listEntity= stdrepos.findAll();
    	
    	List<Employee> listemp= new ArrayList<>();
    	
    	
    	for(EmployeeEntity entity:listEntity) {
    		Employee emp = new Employee();
    		BeanUtils.copyProperties(entity,emp );
    		System.out.println(emp);
    		listemp.add(emp);
    	}
    	
    	model.addAttribute("empdetails",listemp);
    	return "display";
    }
    @RequestMapping(value="/empfind")
    public String viewPage(@RequestParam("id") int curntpage,Model model) {
      int pagesize=4;
    	
    	PageRequest pagerqst= PageRequest.of(curntpage-1,pagesize);
    	
    	Page<EmployeeEntity> page= stdrepos.findbyactive(pagerqst);
    	
    	List<EmployeeEntity> entity= page.getContent();
    	int totalPage=page.getTotalPages();
    	
    	List<Employee> listemp= new ArrayList();
    	for(EmployeeEntity empEntity: entity) {
    		Employee employee =new Employee();
    		BeanUtils.copyProperties(empEntity, employee);
    		System.out.println("<??????????<<<<<<<<<<<?//////////");
    		System.out.println("EMployee<><>"+employee);
    		listemp.add(employee);
    	}
    	model.addAttribute("tp",totalPage);
    	model.addAttribute("cp",curntpage);
    	model.addAttribute("list",listemp);
    	return "display";
    	
    }
    
    
    // method for delete record
    @RequestMapping("/deletemprecord")
    public String deleteRecord(@RequestParam("id") int empno) {
    	stdrepos.deleteByid(empno);
    	return"redirect:/empfind?id=1";
    }
    
    @RequestMapping(value="/updateRecord" )
    public String fatchId( @RequestParam("id") int id,Model model) {
    	 
    	     Optional<EmployeeEntity>findId=stdrepos.findById(id);
            
            if(findId.isPresent()) {
            	EmployeeEntity entity=findId.get();
            	System.out.println("MOdel>>>>>>>"+model);
            	Employee emp= new Employee();
            	BeanUtils.copyProperties(entity, emp);
                model.addAttribute("empId",emp);
                
                System.out.println("NEw EMployee"+emp);
            }
            
           System.out.println("update"+id);
    	return"employeeUpdate";
    }
    
    
    @RequestMapping(value="/updatedetails",method=RequestMethod.POST)
    public String UpdateDetails(@RequestParam("id") int id, @ModelAttribute("empId") Employee employee,Model model ) {
    	EmployeeEntity entity= new EmployeeEntity();
    	BeanUtils.copyProperties(employee, entity);
    	entity.setEmpno(id);
    	stdrepos.save(entity);
    	String msg="Employee details Upated successfully";
    	model.addAttribute("msg",msg);
    	return "employeeUpdate";
    }
    
    @RequestMapping(value="/getEmployee")
    public @ResponseBody List<String> findEmployeeEmail(){
    return stdrepos.findByEmila();
    }
   
    @RequestMapping(value="/empbyid")
    public @ResponseBody List<String> findEmpBYid(@RequestParam("id") int empno){
    	return stdrepos.findByid(empno);
    }

}
