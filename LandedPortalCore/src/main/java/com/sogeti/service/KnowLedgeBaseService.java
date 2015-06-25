package com.sogeti.service;

import java.util.List;

import com.sogeti.model.CustomKnowLedgeBase;
import com.sogeti.model.Customer;
import com.sogeti.model.KnowledgeBase;
import com.sogeti.model.User;

public interface KnowLedgeBaseService {

	public List<CustomKnowLedgeBase> getKnowLedgeBase() throws Exception;
	
	// code added by sachin
	public List<KnowledgeBase> getKnowledgeBaseForAll() throws Exception;
	public List<KnowledgeBase> getKnowledgeBaseForCust(Integer custId) throws Exception;
	public void addKnowledgeBaseForCust(KnowledgeBase know) throws Exception;
	
	public List<Customer> getAllCustomers() throws Exception;
	public Customer getCustomerById(int cid) throws Exception;
	public User getUserById(int uid) throws Exception;
	
}
