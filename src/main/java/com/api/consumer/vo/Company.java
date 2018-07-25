package com.api.consumer.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Company extends Base{


	@Override
	public String toString() {
		return "Company [fundings=" + fundings + "]";
	}

	private  List<Funding> fundings;
	
	public List<Funding> getFundings() {
		return fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}
}
