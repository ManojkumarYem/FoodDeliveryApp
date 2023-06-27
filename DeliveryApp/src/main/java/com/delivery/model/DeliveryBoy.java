package com.delivery.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DeliveryBoyDetails")
public class DeliveryBoy {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int DeviBoyid;

	@Column(name = "name")
	private String name;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "Location")
	private String Location;

	@Column(name = "mailId")
	private String mailId;

	@Column(name = "CreatedAt")
	private LocalDateTime CreatedAt;

	@Column(name = "LoginAt")
	private LocalDateTime LoginAt;

	@Column(name = "LogoutAt")
	private LocalDateTime LogoutAt;

	@Column(name = "aatharNumber")
	private String aatharNumber;

	@Column(name = "LicenseId")
	private String LicenseId;

	@Column(name = "deliveryType")
	private String deliveryType;

	@Column(name = "jobType")
	private String jobType;

	public int getDBoyid() {
		return DeviBoyid;
	}

	public void setDBoyid(int deviBoyid) {
		DeviBoyid = deviBoyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		CreatedAt = createdAt;
	}

	public LocalDateTime getLoginAt() {
		return LoginAt;
	}

	public void setLoginAt(LocalDateTime loginAt) {
		LoginAt = loginAt;
	}

	public LocalDateTime getLogoutAt() {
		return LogoutAt;
	}

	public void setLogoutAt(LocalDateTime logoutAt) {
		LogoutAt = logoutAt;
	}

	public String getAatharNumber() {
		return aatharNumber;
	}

	public void setAatharNumber(String aatharNumber) {
		this.aatharNumber = aatharNumber;
	}

	public String getLicenseId() {
		return LicenseId;
	}

	public void setLicenseId(String licenseId) {
		LicenseId = licenseId;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

}
