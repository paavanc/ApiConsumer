package com.api.consumer;

import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.api.consumer.entity.Country;
import com.api.consumer.utils.TestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = ConsumerApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class ConsumerApplicationTests {
	class Sortbyname implements Comparator<Country> {

		@Override
		public int compare(Country o1, Country o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
	}

	@Autowired
	private MockMvc mvc;
	private static final String COUNTRY_URI = "/country";
	private static final String VALID_INPUT = "IND";
	private static final String INVALID_INPUT = "FAIL";
	private static final String COUNTRY_NAME_ONE = "Afghanistan";
	private static final String COUNTRY_NAME_TWO = "India";

	@Test
	public void testGetAll() throws Exception {

		List<Country> result = TestUtils.getAll(mvc, COUNTRY_URI, Country.class);
		result.sort(new Sortbyname());
		assertTrue(result.get(0).getName().equals(COUNTRY_NAME_ONE));
	}

	@Test
	public void testGetOne() throws Exception {

		Country result = TestUtils.get(mvc, COUNTRY_URI + "/" + VALID_INPUT, Country.class);
		assertTrue(result.getName().equals(COUNTRY_NAME_TWO));
	}

	@Test
	public void testGetOneBad() throws Exception {

		TestUtils.expectBadRequestGet(mvc, COUNTRY_URI + "/" + INVALID_INPUT, Country.class);

	}

}
