package com.aironman.my_spring_mongo_rabbit_aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ItemLog;
import com.aironman.my_spring_mongo_rabbit_aop.repository.mongo.ItemLogRepository;

/**
 * Service implementation for {@link ItemLog}
 * 
 * @author aironman
 */
@Service
@Transactional
public class ItemsService implements IItemsService {
	
	@Autowired
	private ItemLogRepository repository;
	
	public ItemLog create(ItemLog ItemLog) {
		return repository.save(ItemLog);
	}
	@Override
	public ItemLog read(String id) {
		return repository.findOne(id);
	}
	
	@Override
	public List<ItemLog> readAll() {
		return repository.findAll();
	}
	
	public ItemLog update(ItemLog itemLog) {
		ItemLog existingItemLog = repository.findOne(itemLog.getId());
		
		// Assign new values
		existingItemLog.setName(itemLog.getName());
		existingItemLog.setPrize(itemLog.getPrize());
		existingItemLog.setDescription(itemLog.getDescription());
		existingItemLog.setDateAccesed(itemLog.getDateAccesed());
		
		return repository.save(existingItemLog);
	}
	@Override
	public ItemLog delete(String id) {
		repository.delete(id);
		
		return repository.findOne(id);
	}

}
