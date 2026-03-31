package com.mvn_git.study;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvn_git.study.model.City;
import com.mvn_git.study.projection.CityProjection;
import com.mvn_git.study.requests.CityRequest;

@RequestMapping("/api/v1/management")
public interface CityApi {
	
	@PostMapping(
			value="/cityName",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<City> getCityNamez(@RequestBody CityRequest request);

	@PostMapping(
			value="/cityNameList",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<List<City>> getCityNameList(@RequestBody CityRequest request);
	
	@PostMapping(
			value="/cityNamePage",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<Page<City>> getCityNamePage(@RequestBody CityRequest cRequest);
	
	

	@PostMapping(
			value="/cityNameProjPage",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	ResponseEntity<Page<CityProjection>> getCityNameProjPage(@RequestBody CityRequest cRequest);

}
