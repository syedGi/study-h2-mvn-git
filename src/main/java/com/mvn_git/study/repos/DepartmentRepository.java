package com.mvn_git.study.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mvn_git.study.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Find by department name
    Optional<Department> findByName(String name);

    // Find by code
    Optional<Department> findByCode(String code);

    // Find all departments in a location
    List<Department> findByLocation(String location);

    // Custom query method
    List<Department> findByEmployeeCountGreaterThan(Integer count);
    
 // Native query: find by name
    @Query(value = "SELECT * FROM department WHERE name = :name", nativeQuery = true)
    Optional<Department> findByNameNative(@Param("name") String name);

    // Native query: find all departments in a location
    @Query(value = "SELECT * FROM department WHERE location = :location", nativeQuery = true)
    List<Department> findByLocationNative(@Param("location") String location);

    // Native query: get departments with employee count greater than a value
    @Query(value = "SELECT * FROM department WHERE employee_count > :count", nativeQuery = true)
    List<Department> findDepartmentsWithMinEmployees(@Param("count") Integer count);

    // Native query: fetch only specific columns (projection)
    @Query(value = "SELECT name, code FROM department", nativeQuery = true)
    List<Object[]> findDepartmentNamesAndCodes();

    // Native query: count departments by location
    @Query(value = "SELECT COUNT(*) FROM department WHERE location = :location", nativeQuery = true)
    int countByLocationNative(@Param("location") String location);

    // Native query: update employee count
    @Query(value = "UPDATE department SET employee_count = :count WHERE id = :id", nativeQuery = true)
    void updateEmployeeCount(@Param("id") Long id, @Param("count") Integer count);
}