package com.aironman.my_spring_mongo_rabbit_aop.service;

import java.util.List;

import com.aironman.my_spring_mongo_rabbit_aop.domain.Event;
import com.aironman.my_spring_mongo_rabbit_aop.domain.ItemLog;

/**
 * Service interface for {@link Event}
 * 
 * @author aironman
 */
public interface IItemsService {

	public ItemLog create(ItemLog itemLog);

	public ItemLog read(String id);

	public List<ItemLog> readAll();

	public ItemLog update(ItemLog itemLog);

	public ItemLog delete(String id);

}