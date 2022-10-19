package com.metro.repository;

import org.springframework.data.repository.CrudRepository;

import com.metro.domain.Registration;

public interface RegistrationsRepository extends CrudRepository<Registration, Long> {

}
