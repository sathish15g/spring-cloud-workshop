package com.sathish.estimation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sathish.estimation.bean.PlanEstimationBean;
import com.sathish.estimation.service.CableInternetCatalogProxyService;

@RestController
public class PlanEstimationController {
	
	 
	private static final Logger logger = LoggerFactory.getLogger(PlanEstimationController.class);

	@Autowired
	private CableInternetCatalogProxyService proxyService;

	@GetMapping("/estimation-service/{planName}/{noOfHrs}")
	public PlanEstimationBean planEstimate(@PathVariable String planName, @PathVariable BigDecimal noOfHrs) {

		Map<String, String> pathParam = new HashMap<>();
		pathParam.put("planName", planName);

		ResponseEntity<PlanEstimationBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8080/catalog-service/{planName}", PlanEstimationBean.class, pathParam);

		PlanEstimationBean response = responseEntity.getBody();

		return new PlanEstimationBean(response.getPlanName(), response.getDownloadSpeed(), response.getUploadSpeed(),
				response.getChargPerHr(), noOfHrs.multiply(response.getChargPerHr()), response.getPort());

	}

	
	@GetMapping("/estimation-service-feign/{planName}/{noOfHrs}")
	public PlanEstimationBean planEstimateFegin(@PathVariable String planName, @PathVariable BigDecimal noOfHrs) {

		PlanEstimationBean response = proxyService.retrieveCatalog(planName);
		
		logger.info("Plan Estimation service through feign client{}", response);
		return new PlanEstimationBean(response.getPlanName(), response.getDownloadSpeed(), response.getUploadSpeed(),
				response.getChargPerHr(), noOfHrs.multiply(response.getChargPerHr()), response.getPort());

	}
}
