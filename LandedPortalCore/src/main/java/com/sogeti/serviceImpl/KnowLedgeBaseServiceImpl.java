package com.sogeti.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.dao.KnowLedgeBaseServiceDao;
import com.sogeti.model.CustomKnowLedgeBase;
import com.sogeti.service.KnowLedgeBaseService;

@Service("knowLedgeBaseService")
public class KnowLedgeBaseServiceImpl implements KnowLedgeBaseService{

	@Autowired
	KnowLedgeBaseServiceDao knowLedgeBaseServiceDao;
	
	public List<CustomKnowLedgeBase> getKnowLedgeBase() throws Exception {
		// TODO Auto-generated method stub
		
		return knowLedgeBaseServiceDao.getKnowLedgeBase();
	}

}
