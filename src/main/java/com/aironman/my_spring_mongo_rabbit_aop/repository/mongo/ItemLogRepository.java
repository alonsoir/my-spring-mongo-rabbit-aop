package com.aironman.my_spring_mongo_rabbit_aop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ItemLog;

/**
 * @author aironman
 */
public interface ItemLogRepository extends MongoRepository<ItemLog, String> {
}
