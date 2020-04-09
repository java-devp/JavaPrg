package com.example.service;
/*
 * This class is responsible for communicate with repository 
 * @Author Gautam
 */
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeEntity;
import com.example.model.EmployeeModel;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void InsertData(EmployeeModel model) throws Exception {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(model, entity);
		empRepo.save(entity);
	}

	@Override
	public List<EmployeeModel> viewData() {
		Iterable<EmployeeEntity> findAll = empRepo.findAll();
		List<EmployeeModel> emlist = new ArrayList<>();
		findAll.forEach(EmployeeEntity -> {
			EmployeeModel emodel = new EmployeeModel();
			BeanUtils.copyProperties(EmployeeEntity, emodel);
			emlist.add(emodel);
		});
		return emlist;
	}
	
	 

}
