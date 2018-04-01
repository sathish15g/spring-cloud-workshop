package com.sathish.estimation.bean;

import java.math.BigDecimal;

public class PlanEstimationBean {

	private String planName;

	private String downloadSpeed;

	private String uploadSpeed;

	private BigDecimal chargPerHr;

	private BigDecimal planEstimation;
	

	private int port;
	
	public PlanEstimationBean() {
	}
	

	public PlanEstimationBean(String planName, String downloadSpeed, String uploadSpeed, BigDecimal chargPerHr,
			BigDecimal planEstimation, int port) {
		super();
		this.planName = planName;
		this.downloadSpeed = downloadSpeed;
		this.uploadSpeed = uploadSpeed;
		this.chargPerHr = chargPerHr;
		this.planEstimation = planEstimation;
		this.port = port;
	}

	public BigDecimal getPlanEstimation() {
		return planEstimation;
	}


	public void setPlanEstimation(BigDecimal planEstimation) {
		this.planEstimation = planEstimation;
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
