package com.sogeti.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sogeti.dao.KnowLedgeBaseServiceDao;
import com.sogeti.model.CustomKnowLedgeBase;
import com.sogeti.model.Customer;
import com.sogeti.model.KnowledgeBase;
import com.sogeti.model.User;

@Repository("knowLedgeBaseServiceDao")
public class KnowLedgeBaseServiceDaoImpl implements KnowLedgeBaseServiceDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<CustomKnowLedgeBase> getKnowLedgeBase() throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<CustomKnowLedgeBase> customKnowLedgeBaseList = new ArrayList<CustomKnowLedgeBase>();

		try {
			tx = session.beginTransaction();
			Query query = session
					.getNamedQuery(KnowledgeBase.getKnowledgeBaseCustomeData);
			
			List<Object[]> userList = query.list();
			for (int i = 0; i < userList.size(); i++) {
				Object[] obj = (Object[]) userList.get(i);
				CustomKnowLedgeBase customKnowLedgeBase = new CustomKnowLedgeBase();
				customKnowLedgeBase.setCustomerName(obj[0].toString());
				customKnowLedgeBase.setEmployeeName(obj[1].toString());
				customKnowLedgeBase.setQuestion(obj[2].toString());
				customKnowLedgeBase.setAnswer(obj[3].toString());
				customKnowLedgeBase.setInterviewDate(obj[4].toString());
				customKnowLedgeBaseList.add(customKnowLedgeBase);
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return customKnowLedgeBaseList;

	}
	
	
	public void addKnowledgeBaseForCust(KnowledgeBase know) throws Exception {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			  tx = session.beginTransaction();
			  session.save(know);
			  tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		       		
	}
	
	public List<KnowledgeBase> getKnowledgeBaseForCust(Integer custId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<KnowledgeBase> getKnowledgeBaseForAll() throws Exception {	
		List<KnowledgeBase> tempList=new ArrayList<KnowledgeBase>();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			  tx = session.beginTransaction();
			  String hql = "FROM KnowledgeBase KB";
			  Query query = session.createQuery(hql);
			  tempList=query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tempList;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() throws Exception {
		List<Customer> tempCustomerList=new ArrayList<Customer>();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			  tx = session.beginTransaction();
			  String hql = "FROM Customer C";		
			  Query query = session.createQuery(hql);	
			  tempCustomerList=query.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}	  
		return tempCustomerList;
		
	}

	public Customer getCustomerById(int cid) throws Exception {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Customer cust=new Customer();
		try {
			  tx = session.beginTransaction();
			  cust=(Customer)session.get(Customer.class, cid);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return cust;
	}

	public User getUserById(int uid) throws Exception {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		User user=new User();
		try {
			  tx = session.beginTransaction();
			  user=(User)session.get(User.class, uid);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return user;
	}

}
