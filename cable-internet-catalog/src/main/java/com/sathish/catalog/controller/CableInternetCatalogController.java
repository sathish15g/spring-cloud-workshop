package com.sathish.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sathish.catalog.configuration.PropertyConfiguation;
import com.sathish.catalog.model.CableInternetCatalog;
import com.sathish.catalog.service.CableInternetCatalogService;

@RestController
public class CableInternetCatalogController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment env;

	@Autowired
	private CableInternetCatalogService catalogService;

	@Autowired
	private PropertyConfiguation config;

	@GetMapping("/catalog-service/{planName}")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveCatalog")
	public CableInternetCatalog retrieveCatalog(@PathVariable String planName) {
		CableInternetCatalog response = catalogService.retrieveCatalog(planName);
		response.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("retrive plan from catalog service {}", response);
		return response;
	}

	@PostMapping("/catalog-service")
	public CableInternetCatalog postCatalog(@RequestBody CableInternetCatalog cableInternetCatalog) {
		logger.info("posting from catalog-service {}", cableInternetCatalog);

		return catalogService.postCatalog(cableInternetCatalog);
	}

	public CableInternetCatalog fallbackRetrieveCatalog(String planName) {
		return new CableInternetCatalog(config.getPlanName(),config.getDownloadSpeed() , config.getUploadSpeed(), config.getChargPerHr(),Integer.parseInt(env.getProperty("local.server.port")));
	}

}
