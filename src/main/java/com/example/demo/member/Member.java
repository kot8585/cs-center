package com.example.demo.member;

import java.sql.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private Date birth;
	private String gender;
	private String address;
	private String tel;
	private String email;
	
	public Member() {
		super();
	}

	public Member(String id, String password, String name, Date birth, String gender, String address, String tel,
			String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member\n id,password,name,birth,gender,address,tel,email\n"
				+ id + "," + password + "," + name + "," + birth + "," 
				+ gender + "," + address + "," + tel + "," + email;
	}

	
	
}
