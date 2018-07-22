package com.api.consumer.exception;

import org.springframework.http.HttpStatus;

public class ConsumerException extends RuntimeException {

	private HttpStatus code;

	public ConsumerException() {

	}

	public ConsumerException(String message) {
		super(message);
	}

	public ConsumerException(String message, HttpStatus code) {
		super(message);
		this.code = code;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}
}
