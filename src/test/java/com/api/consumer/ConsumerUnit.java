package com.api.consumer;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.api.consumer.entity.Country;
import com.api.consumer.exception.ConsumerException;
import com.api.consumer.manager.impl.ConsumerManagerImpl;
import com.api.consumer.repository.CountryRepository;

@RunWith(MockitoJUnitRunner.class)

public class ConsumerUnit {
	class Sortbyname implements Comparator<Country> {

		@Override
		public int compare(Country o1, Country o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
	}

	@Mock
	CountryRepository counteryRepository;
	@InjectMocks
	ConsumerManagerImpl consumerManagerImpl;

	// Matchers.any(UUID.class), Matchers.anyList(), Matchers.any(Date.class)

	private static final String CODE3 = "AFG";
	private static final String CODE2 = "AF";
	private static final String INVALID_INPUT = "FAIL";
	private static final String COUNTRY_NAME_ONE = "Afghanistan";

	@Test
	public void testGetAll() throws Exception {

		List<Country> result = consumerManagerImpl.getAllCountries();
		result.sort(new Sortbyname());
		assertTrue(result.get(0).getName().equals(COUNTRY_NAME_ONE));
	}

	@Test
	public void testGetOne() throws Exception {
		Mockito.when(counteryRepository.findById(CODE3)).thenReturn(Optional.empty());
		Mockito.when(counteryRepository.save(new Country(COUNTRY_NAME_ONE, CODE2, CODE3)))
				.thenReturn(new Country(COUNTRY_NAME_ONE, CODE2, CODE3));
		Country result = consumerManagerImpl.getCountry(CODE3);
		System.out.println(result);
		assertTrue(result.getName().equals(COUNTRY_NAME_ONE));
	}

	@Test
	public void testGetTwo() throws Exception {
		Mockito.when(counteryRepository.findById(CODE3))
				.thenReturn(Optional.of(new Country(COUNTRY_NAME_ONE, CODE2, CODE3)));
		Country result = consumerManagerImpl.getCountry(CODE3);
		assertTrue(result.getName().equals(COUNTRY_NAME_ONE));
	}

	@Test(expected = ConsumerException.class)
	public void testGetOneBad() throws Exception {

		consumerManagerImpl.getCountry(INVALID_INPUT);

	}
}
