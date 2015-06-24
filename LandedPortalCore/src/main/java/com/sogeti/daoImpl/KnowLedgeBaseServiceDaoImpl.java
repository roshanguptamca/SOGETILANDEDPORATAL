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
import com.sogeti.model.KnowledgeBase;

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

}
