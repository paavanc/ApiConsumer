package com.api.consumer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import com.fasterxml.jackson.annotation.JsonInclude;

@KeySpace("Country")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Country {

	String name;
	String alpha2Code;
	@Id
	String alpha3Code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlpha2Code() {
		return alpha2Code;
	}

	public void setAlpha2Code(String alpha2Code) {
		this.alpha2Code = alpha2Code;
	}

	public String getAlpha3Code() {
		return alpha3Code;
	}

	public void setAlpha3Code(String alpha3Code) {
		this.alpha3Code = alpha3Code;
	}
}
