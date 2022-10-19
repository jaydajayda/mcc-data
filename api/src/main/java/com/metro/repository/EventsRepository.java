package com.metro.repository;

import org.springframework.data.repository.CrudRepository;

import com.metro.domain.Event;

public interface EventsRepository extends CrudRepository<Event, Long> {

}
