package com.api.consumer.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.consumer.entity.Country;


public interface CountryRepository extends CrudRepository<Country, String>{

}
