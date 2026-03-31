package com.mvn_git.study.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvn_git.study.CityApi;
import com.mvn_git.study.model.City;
import com.mvn_git.study.projection.CityProjection;
import com.mvn_git.study.requests.CityRequest;
import com.mvn_git.study.service.CityService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/management")
@Slf4j
public class CityController implements CityApi{
	
	private final CityService cityService;
	
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	@Override
	public ResponseEntity<City> getCityNamez(CityRequest request) {
		return ResponseEntity.ok(cityService.getCityName(request));
	}
	
	@Override
	public ResponseEntity<List<City>> getCityNameList(CityRequest request) {
		return ResponseEntity.ok(cityService.getCityNameList(request));
	}

	@Override
	public ResponseEntity<Page<City>> getCityNamePage(CityRequest cRequest) {
		return ResponseEntity.ok(cityService.getCityNamePage(cRequest));
	}

	@Override
	public ResponseEntity<Page<CityProjection>> getCityNameProjPage(CityRequest cRequest) {
		return ResponseEntity.ok(cityService.getCityNameProjPage(cRequest));
	}

}
