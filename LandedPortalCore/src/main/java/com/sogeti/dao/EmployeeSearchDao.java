package com.sogeti.dao;

import java.util.List;

import com.sogeti.model.Employees;

public interface EmployeeSearchDao {

	public List<Employees> getEmployees() throws Exception;
}
