package com.mvn_git.study.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mvn_git.study.model.User;
import com.mvn_git.study.projection.UserRoleProjection;
import com.mvn_git.study.projection.UserSummaryProjection;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM users u WHERE u.username = :username", nativeQuery = true)
	User findByUsernameNative(@Param("username") String username);

//	@Query(value = "SELECT * FROM users u WHERE u.email LIKE %:domain%", nativeQuery = true)
	@Query(value = "SELECT * FROM users u WHERE u.email LIKE CONCAT('%', :domain, '%')", nativeQuery = true)
	List<User> findByEmailDomain(@Param("domain") String domain);

	@Query(value = "SELECT u.username AS username, u.email AS email FROM users u WHERE u.username = :username", nativeQuery = true)
	List<Object[]> findUserSummaryNative(@Param("username") String username);

	@Query(value = "SELECT u.username AS username, u.email AS email FROM users u WHERE u.username = :username", nativeQuery = true)
	UserSummaryProjection findUserSummaryByUsername(@Param("username") String username);
	
	@Query(value = """
	        SELECT u.username AS username, 
	               u.email AS email, 
	               r.name AS roleName
	        FROM users u
	        JOIN roles r ON u.role_id = r.id
	        WHERE r.name = :roleName
	        """, nativeQuery = true)
	    List<UserRoleProjection> findUsersByRole(@Param("roleName") String roleName);


}
