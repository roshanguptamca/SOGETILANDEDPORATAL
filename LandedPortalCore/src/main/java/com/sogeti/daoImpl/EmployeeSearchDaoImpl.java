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

import com.sogeti.dao.EmployeeSearchDao;
import com.sogeti.model.CustomUser;
import com.sogeti.model.User;

@Repository("employeeDao")
public class EmployeeSearchDaoImpl implements EmployeeSearchDao {

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
			Query query = session.getNamedQuery(User.getUserCustomeData);

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
