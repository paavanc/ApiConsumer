package com.api.consumer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@KeySpace("Country")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Country {

	public Country() {
	}
	public Country(String name,String alpha2Code,String alpha3Code ) {
		this.name = name;
		this.alpha2Code = alpha2Code;
		this.alpha3Code = alpha3Code;
	}
	@Override
	public String toString() {
		return "Country [name=" + name + ", alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code + "]";
	}

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alpha2Code == null) ? 0 : alpha2Code.hashCode());
		result = prime * result + ((alpha3Code == null) ? 0 : alpha3Code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (alpha2Code == null) {
			if (other.alpha2Code != null)
				return false;
		} else if (!alpha2Code.equals(other.alpha2Code))
			return false;
		if (alpha3Code == null) {
			if (other.alpha3Code != null)
				return false;
		} else if (!alpha3Code.equals(other.alpha3Code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
