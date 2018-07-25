package com.api.consumer.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Info extends Base {

	@Override
	public String toString() {
		return "Info [email=" + email + "]";
	}

	private  String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
