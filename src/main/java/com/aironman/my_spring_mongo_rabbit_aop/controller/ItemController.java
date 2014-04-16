package com.aironman.my_spring_mongo_rabbit_aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ItemLog;
import com.aironman.my_spring_mongo_rabbit_aop.dto.ResponseDto;
import com.aironman.my_spring_mongo_rabbit_aop.repository.mongo.ItemLogRepository;
import com.aironman.my_spring_mongo_rabbit_aop.service.IItemsService;

@Controller
@RequestMapping("/items")
public class ItemController {
	

	@Autowired
	private ItemLogRepository itemLogRepository;
	
	@Autowired
	private IItemsService service;
	
	@RequestMapping
	public String getItemsPage() {
		return "items-page";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<ItemLog> add(ItemLog item) {
		
		if (service.create(item) != null) {
			return new ResponseDto<ItemLog>(true);
		}
		
		return new ResponseDto<ItemLog>(false);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<ItemLog> edit(ItemLog item) {
		
		if (service.update(item) != null) {
			return new ResponseDto<ItemLog>(true);
		}

		return new ResponseDto<ItemLog>(false);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<ItemLog> delete(String id) {
		
		if (service.delete(id) == null) {
			return new ResponseDto<ItemLog>(true);
		}
	
		return new ResponseDto<ItemLog>(false);
	}

	@RequestMapping(value = "/getall", method = RequestMethod.POST)
	public @ResponseBody ResponseDto<ItemLog> getall() {

		List<ItemLog> items = itemLogRepository.findAll();
		
		if (items != null) {
			return new ResponseDto<ItemLog>(true, items);
		}

		return new ResponseDto<ItemLog>(false);
	}
	
	
}
