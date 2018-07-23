package com.api.consumer.manager.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.consumer.entity.Country;
import com.api.consumer.manager.ConsumerManager;
import com.api.consumer.repository.CountryRepository;
import com.api.consumer.utils.Constants;
import com.api.consumer.utils.RestUtils;

public class ConsumerManagerImpl implements ConsumerManager {

	@Autowired
	CountryRepository counteryRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.api.consumer.manager.impl.ConsumerManager#getAllCountries()
	 */
	@Override
	public List<Country> getAllCountries() {
		return RestUtils.getAll(Constants.GET_ALL_URI, Country.class, Collections.EMPTY_MAP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.api.consumer.manager.impl.ConsumerManager#getCountry(java.lang.String)
	 */
	@Override
	public Country getCountry(String alpha3Code) {
		Country dbCountry = checkDB(alpha3Code);
		if (dbCountry != null) {
			return dbCountry;
		}
		return counteryRepository.save(
				(Country) RestUtils.get(Constants.GET_ONE_URI + alpha3Code, Country.class, Collections.EMPTY_MAP));
	}

	private Country checkDB(String alpha3Code) {

		Optional<Country> paths = counteryRepository.findById(alpha3Code);

		if (!paths.isPresent()) {
			return null;
		}
		return paths.get();
	}

}
