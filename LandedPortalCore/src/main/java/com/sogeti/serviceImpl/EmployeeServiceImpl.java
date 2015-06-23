package com.sogeti.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.dao.EmployeeSearchDao;
import com.sogeti.model.CustomUser;
import com.sogeti.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeSearchDao employeeDao;

	public List<CustomUser> getEmployees() throws Exception {

		return employeeDao.getEmployees();
	}

}
