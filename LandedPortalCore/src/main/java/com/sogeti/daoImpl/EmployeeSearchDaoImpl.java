package com.sogeti.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sogeti.dao.EmployeeSearchDao;
import com.sogeti.model.CustomUser;

@Repository("employeeDao")
public class EmployeeSearchDaoImpl implements EmployeeSearchDao {

	public static final String getCustomUser = "select  users.emp_id,users.name,user_address.address,user_phone.contactno from users,user_address,user_phone ";
	
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<CustomUser> getEmployees() throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<CustomUser> customUserList = new ArrayList<CustomUser>();

		try {
			tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(getCustomUser);
		
			List<Object[]> userList = query.list();
			for (int i = 0; i < userList.size(); i++) {
				Object[] obj = (Object[]) userList.get(i);
				CustomUser customUser = new CustomUser();
				customUser.setEmp_id(obj[0].toString());
				customUser.setName(obj[1].toString());
				customUser.setAddress(obj[2].toString());
				customUser.setContactno(obj[3].toString());
				customUserList.add(customUser);
			}
			
			CustomUser customUser = new CustomUser();
			customUser.setEmp_id("456");
			customUser.setName("abcd");
			customUser.setAddress("uuu");
			customUser.setContactno("7824");
			customUserList.add(customUser);
			
			CustomUser customUser1 = new CustomUser();
			customUser1.setEmp_id("789");
			customUser1.setName("pqrs");
			customUser1.setAddress("uuu");
			customUser1.setContactno("7824");
			customUserList.add(customUser1);
			
			CustomUser customUser2 = new CustomUser();
			customUser2.setEmp_id("14566");
			customUser2.setName("xyz");
			customUser2.setAddress("uuu");
			customUser2.setContactno("7824");
			customUserList.add(customUser2);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customUserList;
	}
}
