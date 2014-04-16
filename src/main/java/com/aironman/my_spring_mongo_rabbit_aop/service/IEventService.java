package com.aironman.my_spring_mongo_rabbit_aop.service;

import java.util.List;

import com.aironman.my_spring_mongo_rabbit_aop.domain.Event;


/**
 * Service interface for {@link Event}
 * 
 * @author aironman
 */
public interface IEventService {

	public Event create(Event event);

	public Event read(Long id);

	public List<Event> readAll();

	public Event update(Event event);

	public Event delete(Long id);

}