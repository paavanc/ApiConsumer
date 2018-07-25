package com.api.consumer.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Funding {

	@Override
	public String toString() {
		return "Funding [idFunding=" + idFunding + ", amount=" + amount + ", date=" + date + "]";
	}
	private Long idFunding;
	private Double amount;
	private String date;
	
	public Long getIdFunding() {
		return idFunding;
	}
	public void setIdFunding(Long idFunding) {
		this.idFunding = idFunding;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
