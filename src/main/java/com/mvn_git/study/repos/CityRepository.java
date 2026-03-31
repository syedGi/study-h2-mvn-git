package com.mvn_git.study.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvn_git.study.model.City;
import com.mvn_git.study.projection.CityProjection;

public interface CityRepository extends JpaRepository<City, Long> {

//	@Query(value="""
//			SELECT C.NAME FROM CITY C
//			JOIN COUNTRY CT ON C.COUNTRY_CODE = CT.CODE
//			""", nativeQuery=true)
	@Query(value="""
			SELECT C.* FROM CITY C
			JOIN COUNTRY CT ON C.COUNTRY_CODE = CT.CODE LIMIT 1
			""", nativeQuery=true)
	City getCityWithCountryCode();
	
	@Query(value="""
			SELECT C.* FROM CITY C
			JOIN COUNTRY CT ON C.COUNTRY_CODE = CT.CODE
			""", nativeQuery=true)
	List<City> getCityWithCountryCodeList();
	
	@Query(
		    value = """
		    		SELECT C.* FROM CITY C 
		    		JOIN COUNTRY CT ON C.COUNTRY_CODE = CT.CODE
		    		""",
		    		
		    countQuery = """
		    		SELECT COUNT(*) FROM CITY C 
		    		JOIN COUNTRY CT ON C.COUNTRY_CODE = CT.CODE
		    		""",
		    nativeQuery = true
		)
	Page<City> getCityWithCountryCodePage(Pageable pageable);
	
	
	
	@Query(value = """
		            SELECT 
		                C.ID as id, 
		                C.Name as name, 
		                C.Country_Code as countryCode, 
		                C.District as district, 
		                C.Population as population 
		            FROM CITY C 
		            JOIN COUNTRY CT ON C.COUNTRY_CODE = CT.CODE
		            """,
		    countQuery = """
		    			 SELECT COUNT(*) FROM CITY C JOIN COUNTRY CT 
		    			 ON C.COUNTRY_CODE = CT.CODE
		    			""",
		    nativeQuery = true)
		Page<CityProjection> getCityProjectioonPage(Pageable pageable);
}
