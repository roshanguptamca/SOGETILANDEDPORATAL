package com.sogeti.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.dao.KnowLedgeBaseServiceDao;
import com.sogeti.model.CustomKnowLedgeBase;
import com.sogeti.model.Customer;
import com.sogeti.model.KnowledgeBase;
import com.sogeti.model.User;
import com.sogeti.service.KnowLedgeBaseService;

@Service("knowLedgeBaseService")
public class KnowLedgeBaseServiceImpl implements KnowLedgeBaseService{

	@Autowired
	KnowLedgeBaseServiceDao knowLedgeBaseServiceDao;
	
	public List<CustomKnowLedgeBase> getKnowLedgeBase() throws Exception {
		// TODO Auto-generated method stub
		
		return knowLedgeBaseServiceDao.getKnowLedgeBase();
	}
	
	public List<KnowledgeBase> getKnowledgeBaseForCust(Integer custId) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void addKnowledgeBaseForCust(KnowledgeBase know) throws Exception{
		knowLedgeBaseServiceDao.addKnowledgeBaseForCust(know);		
	}

	@Transactional
	public List<KnowledgeBase> getKnowledgeBaseForAll() throws Exception {		
		return knowLedgeBaseServiceDao.getKnowledgeBaseForAll();
	}

	@Transactional
	public List<Customer> getAllCustomers() throws Exception {
		return knowLedgeBaseServiceDao.getAllCustomers();
	}

	@Transactional
	public Customer getCustomerById(int cid) throws Exception {
		return knowLedgeBaseServiceDao.getCustomerById(cid);
	}

	@Transactional
	public User getUserById(int uid) throws Exception {
		return knowLedgeBaseServiceDao.getUserById(uid);
	}

}
