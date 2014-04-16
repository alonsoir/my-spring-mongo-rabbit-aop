package com.aironman.my_spring_mongo_rabbit_aop.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aironman.my_spring_mongo_rabbit_aop.domain.Event;

/**
 * A repository for {@link Event}
 * 
 * @author aironman
 */
public interface IEventRepository extends JpaRepository<Event, Long> {
}
