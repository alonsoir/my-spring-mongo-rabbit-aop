package com.aironman.my_spring_mongo_rabbit_aop.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aironman.my_spring_mongo_rabbit_aop.domain.ErrorLog;

/**
 * @author aironman
 */
public interface IErrorLogRepository extends MongoRepository<ErrorLog, String> {
}
