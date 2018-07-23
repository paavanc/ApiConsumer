package com.api.consumer.manager;

import java.util.List;

import com.api.consumer.entity.Country;

public interface ConsumerManager {

	List<Country> getAllCountries();

	Country getCountry(String alpha3Code);

}