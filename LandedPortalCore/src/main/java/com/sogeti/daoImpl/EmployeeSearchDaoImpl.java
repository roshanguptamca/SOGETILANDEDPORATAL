package com.sogeti.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sogeti.dao.EmployeeSearchDao;
import com.sogeti.model.Employees;

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

	public List<Employees> getEmployees() throws Exception {

		return null;
	}

}
