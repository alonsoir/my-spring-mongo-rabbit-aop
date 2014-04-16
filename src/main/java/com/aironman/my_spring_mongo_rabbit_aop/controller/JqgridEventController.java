package com.aironman.my_spring_mongo_rabbit_aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aironman.my_spring_mongo_rabbit_aop.domain.Event;
import com.aironman.my_spring_mongo_rabbit_aop.dto.JqgridTableDto;
import com.aironman.my_spring_mongo_rabbit_aop.dto.ResponseDto;
import com.aironman.my_spring_mongo_rabbit_aop.service.IEventService;

/**
 * Controlling for handling event requests
 * 
 * @author aironman
 */
@Controller
@RequestMapping("/jqgrid/event")
public class JqgridEventController {
	
	@Autowired
	private volatile IEventService service;

	@RequestMapping
	public String getEventPage() {
		return "jqgrid/event-page";
	}

	@CacheEvict(value = "records", allEntries=true)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<Event> add(Event event) {
		
		if (service.create(event) != null) {
			return new ResponseDto<Event>(true);
		}
		
		return new ResponseDto<Event>(false);
	}
	
	@CacheEvict(value = "records", allEntries=true)
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<Event> edit(Event event) {
		
		if (service.update(event) != null) {
			return new ResponseDto<Event>(true);
		}

		return new ResponseDto<Event>(false);
	}

	@CacheEvict(value = "records", allEntries=true)
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<Event> delete(Long id) {
		
		if (service.delete(id) == null) {
			return new ResponseDto<Event>(true);
		}
	
		return new ResponseDto<Event>(false);
	}
	
	@Cacheable(value = "records")
	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public @ResponseBody JqgridTableDto<Event> getall() {

		List<Event> events = service.readAll();
		
		if (events != null) {
			JqgridTableDto<Event> response = new JqgridTableDto<Event>();
			response.setRows(events);
			response.setRecords(new Integer(events.size()).toString());
			response.setTotal(new String("1"));
			response.setPage(new String("1"));
			
			return response;
		}
		
		return new JqgridTableDto<Event>();
	}
}
