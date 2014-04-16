package com.aironman.my_spring_mongo_rabbit_aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.my_spring_mongo_rabbit_aop.domain.Event;
import com.aironman.my_spring_mongo_rabbit_aop.repository.jpa.IEventRepository;

/**
 * Service implementation for {@link Event}
 * 
 * @author aironman
 */
@Service
@Transactional
public class EventService implements IEventService {
	
	@Autowired
	private IEventRepository repository;
	
	public Event create(Event event) {
		return repository.save(event);
	}
	
	public Event read(Long id) {
		return repository.findOne(id);
	}
	
	public List<Event> readAll() {
		return repository.findAll();
	}
	
	public Event update(Event event) {
		Event existingEvent = repository.findOne(event.getId());
		
		// Assign new values
		existingEvent.setName(event.getName());
		existingEvent.setParticipants(event.getParticipants());
		existingEvent.setDescription(event.getDescription());
		existingEvent.setDate(event.getDate());
		
		return repository.save(existingEvent);
	}
	
	public Event delete(Long id) {
		repository.delete(id);
		
		return repository.findOne(id);
	}
}
