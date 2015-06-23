package com.sogeti.service;

import java.util.List;

import com.sogeti.model.CustomUser;

public interface EmployeeService {
	public List<CustomUser> getEmployees() throws Exception;
}
