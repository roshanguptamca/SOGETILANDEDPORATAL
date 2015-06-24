package com.sogeti.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.model.CustomKnowLedgeBase;
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
}
