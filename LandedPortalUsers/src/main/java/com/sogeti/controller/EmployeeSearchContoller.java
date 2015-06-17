package com.sogeti.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.model.Employees;
import com.sogeti.service.EmployeeService;

@RestController
public class EmployeeSearchContoller {

	@Autowired
	EmployeeService employeeService;
	private static final Logger logger = Logger
			.getLogger(EmployeeSearchContoller.class);

	@RequestMapping(value = "/employeeSearch/", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public List<Employees> getEmployees() {

		List<Employees> employeesList = new ArrayList<Employees>();

		try {
			employeesList = employeeService.getEmployees();
		} catch (Exception e) {
			logger.error("Exception during search if employee" + e);
		}
		return employeesList;

	}
}
