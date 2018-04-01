package com.sathish.estimation.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sathish.estimation.bean.PlanEstimationBean;

//@FeignClient(name="cable-interent-catalog", url="localhost:8080")
//@FeignClient(name = "cable-interent-catalog")
@FeignClient(name="zuul-api-gateway-service")
@RibbonClient(name = "cable-interent-catalog")
public interface CableInternetCatalogProxyService {

	//@GetMapping("/catalog-service/{planName}")
	@GetMapping("/cable-interent-catalog/catalog-service/{planName}")
	public PlanEstimationBean retrieveCatalog(@PathVariable("planName") String planName);

}
