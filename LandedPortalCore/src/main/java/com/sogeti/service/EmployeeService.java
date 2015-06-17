package com.sogeti.service;

import java.util.List;

import com.sogeti.model.Employees;

public interface EmployeeService {
	public List<Employees> getEmployees() throws Exception;
}
