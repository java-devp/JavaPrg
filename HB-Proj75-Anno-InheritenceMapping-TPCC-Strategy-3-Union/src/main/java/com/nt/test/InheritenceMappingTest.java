package com.nt.test;

import com.nt.dao.PaymentDAO;
import com.nt.dao.PaymentDAOFactory;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingTest {
	public static void main(String[] args) {
		PaymentDAO dao=null;
		
		dao=PaymentDAOFactory.getInstance();
		
		dao.saveData();
		//dao.loadData();
		HibernateUtil.closeSessionFactory();
	}

}
