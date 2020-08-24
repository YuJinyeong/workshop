package com.ssafy.happyhouse.model.dto;

public class Env {
	private String name;// 시설명
	private String clas;// 업종
	private String date;// 지도점검일자
	private String check;// 지도점검구분
	private String address;// 소재지

	public Env() {
	}

	public Env(String name, String clas, String date, String check, String address) {
		this.name = name;
		this.clas = clas;
		this.date = date;
		this.check = check;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return name;
	}

	public String getDescription() {
		return "Env [name=" + name + ", clas=" + clas + ", date=" + date + ", check=" + check + ", address=" + address
				+ "]";
	}
}
