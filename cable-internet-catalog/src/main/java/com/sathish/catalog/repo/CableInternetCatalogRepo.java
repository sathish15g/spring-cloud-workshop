package com.sathish.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.catalog.model.CableInternetCatalog;

public interface CableInternetCatalogRepo extends JpaRepository<CableInternetCatalog,String>{

	CableInternetCatalog findByPlanName(String planName);

}
