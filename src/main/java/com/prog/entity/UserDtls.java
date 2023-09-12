package com.prog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_DTLS")
public class UserDtls {
	
@Id //for do id as primary key
@GeneratedValue(strategy = GenerationType.AUTO)  //for auto increment
private int id;
@Column(name ="Name")
private String fullname;
private String gender;
private String dob;
private String address;
private String pincode;
private String email;
private String password;
private String role;

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserDtls(int id, String fullname, String gender, String dob, String address, String email, String password,
		String role) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.gender = gender;
	this.dob = dob;
	this.address = address;
	this.email = email;
	this.password = password;
	this.role = role;
}
public UserDtls() {
	super();
	// TODO Auto-generated constructor stub
}


@Override
public String toString() {
	return "UserDtls [id=" + id + ", fullname=" + fullname + ", gender=" + gender + ", dob=" + dob + ", address="
			+ address + ", pincode=" + pincode + ", email=" + email + ", password=" + password + ", role=" + role + "]";
}
public String getPincode() {
	return pincode;
}
public void setPincode(String pincode) {
	this.pincode = pincode;
}




}
