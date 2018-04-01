package com.sathish.catalog.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "catalog_table")
@JsonIgnoreProperties
public class CableInternetCatalog {

	@Id
	private String planName;

	@Column(name = "download_speed")
	private String downloadSpeed;

	@Column(name = "upload_speed")
	private String uploadSpeed;

	@Column(name = "charge_per_hr")
	private BigDecimal chargPerHr;

	private int port;
	
	public CableInternetCatalog() {
	}
	
	public CableInternetCatalog(String planName, String downloadSpeed, String uploadSpeed, BigDecimal chargPerHr, int port) {
		super();
		this.planName = planName;
		this.downloadSpeed = downloadSpeed;
		this.uploadSpeed = uploadSpeed;
		this.chargPerHr = chargPerHr;
		this.port = port;
	}
	

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDownloadSpeed() {
		return downloadSpeed;
	}

	public void setDownloadSpeed(String downloadSpeed) {
		this.downloadSpeed = downloadSpeed;
	}

	public String getUploadSpeed() {
		return uploadSpeed;
	}

	public void setUploadSpeed(String uploadSpeed) {
		this.uploadSpeed = uploadSpeed;
	}

	public BigDecimal getChargPerHr() {
		return chargPerHr;
	}

	public void setChargPerHr(BigDecimal chargPerHr) {
		this.chargPerHr = chargPerHr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}


}
