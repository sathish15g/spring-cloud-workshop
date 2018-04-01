package com.sathish.catalog.configuration;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cable-interent-catalog.default")
public class PropertyConfiguation {

	
	private String planName;

	private String downloadSpeed;

	private String uploadSpeed;

	private BigDecimal chargPerHr;
	
	
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

	
}
