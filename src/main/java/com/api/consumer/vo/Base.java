package com.api.consumer.vo;

public class Base {

	public Base() {

	}

	public Base(Long idCompany, String company) {
		this.idCompany = idCompany;
		this.company = company;
	}

	private Long idCompany;
	private String company;

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
