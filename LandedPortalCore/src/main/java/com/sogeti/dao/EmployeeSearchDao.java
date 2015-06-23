package com.sogeti.dao;

import java.util.List;

import com.sogeti.model.CustomUser;

public interface EmployeeSearchDao  {

	public List<CustomUser> getEmployees() throws Exception;
}
