/*package com.sogeti.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	private EntityManager entityManager;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("TESTJPA");
		entityManager = emf.createEntityManager();
	}

	*//**
	 * Test new user.
	 *//*
	@Test
	public void testNewUser() {
		UserRole userRole = new UserRole();
		userRole.setRoleName("admin");

		User user = new User();
		user.setEmpId("123");
		user.setDob(new Date());
		user.setLandedDate(new Date());
		user.setLastlogin(new Date());
		user.setName("rus");
		user.setPassword("123");

		user.setCustomerDetails(null);
		user.setEmpPhoto(null);
		user.setKnowledgeBases(null);
		user.setUserAddresses(null);
		user.setUserMotivations(null);
		user.setUserResumes(null);
		user.setUserRole(userRole);
		entityManager.persist(user);

		try {
			EntityTransaction entr = entityManager.getTransaction();
			entr.begin();
			entityManager.persist(userRole);
			entr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}

		System.out.println("success");
	}
}
*/