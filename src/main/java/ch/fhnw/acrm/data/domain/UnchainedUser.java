/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package ch.fhnw.acrm.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;

// Author: Alex
@Entity
public class UnchainedUser {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String street;
	private String zipCode;
	private String city;
	private int travelDistance;
	@Email
	private String email;
	private boolean isAnAdmin;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@JsonIgnore
	private String role = "USER";
	@Transient // will not be stored in DB
	private String remember;


	public UnchainedUser(){}

	public UnchainedUser(String name, String street, String zipCode, String city, int travelDistance, String email, boolean isAnAdmin, String password, String role) {
		this.name = name;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.travelDistance = travelDistance;
		this.email = email;
		this.isAnAdmin = isAnAdmin;
		this.password = password;
		this.role = role;
	}

	//getter and setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public int getTravelDistance() {
		return travelDistance;
	}
	public void setTravelDistance(int travelDistance) {
		this.travelDistance = travelDistance;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAnAdmin() {
		return isAnAdmin;
	}
	public void setAnAdmin(boolean anAdmin) {
		isAnAdmin = anAdmin;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {this.role = role;}

	public String getRemember() {
		return remember;
	}
	public void setRemember(String remember) {
		this.remember = remember;
	}

}
