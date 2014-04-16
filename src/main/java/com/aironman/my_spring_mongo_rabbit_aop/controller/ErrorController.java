package com.aironman.my_spring_mongo_rabbit_aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ErrorLog;
import com.aironman.my_spring_mongo_rabbit_aop.dto.ResponseDto;
import com.aironman.my_spring_mongo_rabbit_aop.repository.mongo.IErrorLogRepository;

@Controller
@RequestMapping("/error")
public class ErrorController {
	

	@Autowired
	private IErrorLogRepository errorLogRepository;
	
	@RequestMapping
	public String getErrorPage() {
		return "error-page";
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<ErrorLog> getall() {

		List<ErrorLog> errors = errorLogRepository.findAll();
		
		if (errors != null) {
			return new ResponseDto<ErrorLog>(true, errors);
		}

		return new ResponseDto<ErrorLog>(false);
	}
}
