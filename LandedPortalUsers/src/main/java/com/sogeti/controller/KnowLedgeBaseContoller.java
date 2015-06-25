package com.sogeti.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.VO.CustomerVO;
import com.sogeti.VO.KnowledgeBaseVO;
import com.sogeti.model.CustomKnowLedgeBase;
import com.sogeti.model.Customer;
import com.sogeti.model.KnowledgeBase;
import com.sogeti.service.KnowLedgeBaseService;

@RestController
public class KnowLedgeBaseContoller {

	private static final Logger logger = Logger
			.getLogger(KnowLedgeBaseContoller.class);

	@Autowired(required = true)
	KnowLedgeBaseService knowLedgeBaseService;

	@RequestMapping(value = "/kbSearch", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public List<CustomKnowLedgeBase> getKnowLedgeBase() {

		List<CustomKnowLedgeBase> customKnowLedgeBaseList = new ArrayList<CustomKnowLedgeBase>();
		try {
			customKnowLedgeBaseList = knowLedgeBaseService.getKnowLedgeBase();
		} catch (Exception e) {
			logger.error("Exception during search if employee" + e);
		}
		return customKnowLedgeBaseList;
	}
	
	
	// Code added by sachin
	@RequestMapping(value="/getAllKnowledgeBase",method=RequestMethod.GET)
	@ResponseBody
	public List<KnowledgeBaseVO> getAllKnowledgebase() {		
		List<KnowledgeBase> knowledgeBaseList = new ArrayList<KnowledgeBase>();
		List<KnowledgeBaseVO> knowledgeBaseVOList = new ArrayList<KnowledgeBaseVO>();
		KnowledgeBaseVO kbvo=null;
		try {
				knowledgeBaseList = knowLedgeBaseService.getKnowledgeBaseForAll();			
				for(KnowledgeBase kb : knowledgeBaseList){
					kbvo=new KnowledgeBaseVO();
					kbvo.setCustomerName(kb.getCustomer().getCustomername());
					kbvo.setEmployeeName(kb.getUser().getName());
					kbvo.setQuestion(kb.getQuestion());
					kbvo.setAnswer(kb.getAnswer());
					kbvo.setInterviewDate(kb.getInterviewDate());					
					knowledgeBaseVOList.add(kbvo);
			    }
			
		} catch (Exception e) {
			logger.error("Exception during search if employee" + e);
		}		
		return knowledgeBaseVOList;
	}
	
	
	@RequestMapping(value="/getAllCustomers",method=RequestMethod.GET)
	@ResponseBody
	public List<CustomerVO> getAllCustomers() {		
		List<Customer> customerList = new ArrayList<Customer>();
		List<CustomerVO> customerVOList = new ArrayList<CustomerVO>();
		CustomerVO cvo=null;
		try {
			    customerList = knowLedgeBaseService.getAllCustomers();			    
				for(Customer cust : customerList){
					cvo=new CustomerVO();
					cvo.setCid(cust.getCid());
					cvo.setCustomerName(cust.getCustomername());
					customerVOList.add(cvo);
			 }		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception during search if employee" + e);
		}	
		return customerVOList;
	}
	
	@RequestMapping(value = "/addKnowledgeBase",method=RequestMethod.POST)
    public @ResponseBody List<KnowledgeBaseVO> createKnowledgeBase(@RequestBody KnowledgeBaseVO kbvo) {
		List<KnowledgeBaseVO> knowledgeBaseList = new ArrayList<KnowledgeBaseVO>();
		try {
			KnowledgeBase tempKB=new KnowledgeBase();
			tempKB.setCustomer(knowLedgeBaseService.getCustomerById(kbvo.getCid()));
			tempKB.setUser(knowLedgeBaseService.getUserById(kbvo.getUid()));
			tempKB.setQuestion(kbvo.getQuestion());
			tempKB.setAnswer(kbvo.getAnswer());
			tempKB.setInterviewDate(kbvo.getInterviewDate());
			knowLedgeBaseService.addKnowledgeBaseForCust(tempKB);
			knowledgeBaseList=this.getAllKnowledgebase();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Exception during search if employee" + e);
		}		
		return knowledgeBaseList;
    }
	
}
