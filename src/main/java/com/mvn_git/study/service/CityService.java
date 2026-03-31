package com.mvn_git.study.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mvn_git.study.model.City;
import com.mvn_git.study.projection.CityProjection;
import com.mvn_git.study.requests.CityRequest;

//@Service
public interface CityService {

	City getCityName(CityRequest request);
	
	List<City> getCityNameList(CityRequest request);
	
	Page<City> getCityNamePage(CityRequest cRequest);
	
	Page<CityProjection> getCityNameProjPage(CityRequest proRequest);
	
	Page<CityProjection> getCityNameProjPageSort(CityRequest sortRequest);
}
