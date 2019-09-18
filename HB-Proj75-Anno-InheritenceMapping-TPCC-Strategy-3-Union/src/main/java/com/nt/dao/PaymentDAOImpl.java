package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {

	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		CardPayment cardPayment=null;
		ChequePayment chequePayment=null;
		boolean flag=false;
		
		cardPayment=new CardPayment();
		cardPayment.setName("jon");
		cardPayment.setAmount(8000.0f);
		cardPayment.setCardNo(512546);
		cardPayment.setCardType("VISA-DEBIT");
		cardPayment.setCvvNo(123);

        chequePayment=new ChequePayment();
        chequePayment.setName("gour");
        chequePayment.setAmount(65500.0f);
        chequePayment.setChequeNo(5234);
        chequePayment.setChequeType("SELF-CHEQUE");
        chequePayment.setBankName("SBI");
			
		ses=HibernateUtil.getSession();
		
		try {
			tx=ses.beginTransaction();
			ses.save(cardPayment);
			ses.save(chequePayment);
			flag=true;
		}
		catch (HibernateException he) {
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			HibernateUtil.closeSession(ses);
		}

	}

	public void loadData() {

		Session ses=null;
		Query query=null;
		List<Payment> listPayments=null;
		List<CardPayment> listCards=null;
		List<ChequePayment> listCheques=null;
		
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from Payment");
		listPayments=query.getResultList();
		listPayments.forEach(pay->{
			System.out.println(pay);
		});
		
		System.out.println("---------------------------------");
		query=ses.createQuery("from CardPayment");
		listCards=query.getResultList();
		listCards.forEach(card->{
			System.out.println(card);
		});
		
		System.out.println("---------------------------------");
		query=ses.createQuery("from ChequePayment");
		listCheques=query.getResultList();
		listCheques.forEach(cheque->{
			System.out.println(cheque);
		});
		
		
		HibernateUtil.closeSession(ses);
		
		
		
	}

}
