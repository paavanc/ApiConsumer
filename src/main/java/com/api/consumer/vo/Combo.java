package com.api.consumer.vo;

import java.util.List;

public class Combo extends Base {



	@Override
	public String toString() {
		return "Combo [email=" + email + ", fundings=" + fundings + ", getIdCompany()=" + getIdCompany()
				+ ", getCompany()=" + getCompany() + "]";
	}

	public Combo() {

	}

	public Combo(Info in) {

		super(in.getIdCompany(), in.getCompany());
		this.email = in.getEmail();
	}

	public Combo(Company ca) {

		super(ca.getIdCompany(), ca.getCompany());
		this.fundings = ca.getFundings();
	}

	public void setCompany(Company ca) {
		this.fundings = ca.getFundings();
	}

	private String email;
	private List<Funding> fundings;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Funding> getFundings() {
		return fundings;
	}

	public void setFundings(List<Funding> fundings) {
		this.fundings = fundings;
	}

}
