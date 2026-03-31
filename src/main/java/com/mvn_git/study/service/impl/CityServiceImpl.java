package com.mvn_git.study.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mvn_git.study.model.City;
import com.mvn_git.study.projection.CityProjection;
import com.mvn_git.study.repos.CityRepository;
import com.mvn_git.study.requests.CityRequest;
import com.mvn_git.study.service.CityService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CityServiceImpl implements CityService{
	
	private final CityRepository cityRepository;
	
	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public City getCityName(CityRequest request) {
		
		return cityRepository.getCityWithCountryCode();
	}
	
	@Override
	public List<City> getCityNameList(CityRequest request) {
		List<City> cities = cityRepository.getCityWithCountryCodeList();
		log.info("citiezSizE::{}",cities.size());
		return cities;
	}

	@Override
	public Page<City> getCityNamePage(CityRequest cRequest) {
		Pageable pageable = PageRequest.of(cRequest.getPageNumber(), cRequest.getPageSize());
		Page<City> cityPage = cityRepository.getCityWithCountryCodePage(pageable);
		log.info("City--Page::{}",cityPage);
		return cityPage;
	}

	@Override
	public Page<CityProjection> getCityNameProjPage(CityRequest proRequest) {
		Pageable pageable = PageRequest.of(proRequest.getPageNumber(), proRequest.getPageSize());
		Page<CityProjection> cityProjPage = cityRepository.getCityProjectioonPage(pageable);
		log.info("City-Proj-Page::{}",cityProjPage);
		return cityProjPage;
	}

}
