package com.model;

public class customer {
	private int custid;
	private String custname;
	private String mobno;
	private String email;
	private String city;
	private String state;
	
	public customer(int custid, String custname, String mobno, String email, String city, String state) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.mobno = mobno;
		this.email = email;
		this.city = city;
		this.state = state;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
