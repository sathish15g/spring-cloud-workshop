package com.sathish.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathish.catalog.model.CableInternetCatalog;
import com.sathish.catalog.repo.CableInternetCatalogRepo;

@Service
public class CableInternetCatalogService {

	@Autowired
	private CableInternetCatalogRepo cableInternetCatalogRepo;

	public CableInternetCatalog retrieveCatalog(String planName) {
		return cableInternetCatalogRepo.findByPlanName(planName);
	}

	public CableInternetCatalog postCatalog(CableInternetCatalog cableInternetCatalog) {
		return cableInternetCatalogRepo.save(cableInternetCatalog);
	}

}
