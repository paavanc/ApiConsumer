package com.api.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.consumer.entity.Country;
import com.api.consumer.manager.ConsumerManager;

@RestController
@RequestMapping("/country")
public class Controller {

	@Autowired
	ConsumerManager consumerManager;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Country> getAll() {
		return consumerManager.getAllCountries();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Country getOne(@PathVariable(required = true, name = "id") String code3) {
		return consumerManager.getCountry(code3);
	}

}
