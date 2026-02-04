package com.mvn_git.study.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.mvn_git.study.model.Role;
import com.mvn_git.study.model.User;
import com.mvn_git.study.model.dto.UserSummary;
import com.mvn_git.study.projection.UserRoleProjection;
import com.mvn_git.study.projection.UserSummaryProjection;
import com.mvn_git.study.repos.UserRepository;

@DataJpaTest // spins up in-memory DB (H2) and configures JPA repositories
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void testFindByUsernameNative() {
		// Arrange: create and save a user
		User user = new User();
		user.setUsername("mohamed");
		user.setEmail("mohamed@example.com");
		userRepository.save(user);

		// Act: call the native query
		User found = userRepository.findByUsernameNative("mohamed");

		// Assert: verify result
		assertThat(found).isNotNull();
		assertThat(found.getEmail()).isEqualTo("mohamed@example.com");
	}

	@Test
	void testFindByEmailDomain() {
		// Arrange
		User u1 = new User();
		u1.setUsername("alice");
		u1.setEmail("alice@gmail.com");
		userRepository.save(u1);

		User u2 = new User();
		u2.setUsername("bob");
		u2.setEmail("bob@gmail.com");
		userRepository.save(u2);

		User u3 = new User();
		u3.setUsername("charlie");
		u3.setEmail("charlie@yahoo.com");
		userRepository.save(u3);

		// Act
		List<User> gmailUsers = userRepository.findByEmailDomain("gmail.com");
//		userRepository.findByEmailDomain("%gmail.com%");

		// Assert
		assertThat(gmailUsers).hasSize(2);
		assertThat(gmailUsers).extracting(User::getUsername).containsExactlyInAnyOrder("alice", "bob");
	}

	@Test
	void testFindUserSummaryNative() {
		// Arrange
		User user = new User();
		user.setUsername("mohamed");
		user.setEmail("mohamed@example.com");
		userRepository.save(user);

		// Act
		List<Object[]> result = userRepository.findUserSummaryNative("mohamed");

		// Convert to DTO
		List<UserSummary> summaries = result.stream().map(r -> new UserSummary((String) r[0], (String) r[1])).toList();

		// Assert
		assertThat(summaries).hasSize(1);
		assertThat(summaries.get(0).getEmail()).isEqualTo("mohamed@example.com");
	}

	@Test
	void testFindUserSummaryByUsername() {
		// Arrange
		User user = new User();
		user.setUsername("mohamed");
		user.setEmail("mohamed@example.com");
		userRepository.save(user);

		// Act
		UserSummaryProjection summary = userRepository.findUserSummaryByUsername("mohamed");

		// Assert
		assertThat(summary).isNotNull();
		assertThat(summary.getUsername()).isEqualTo("mohamed");
		assertThat(summary.getEmail()).isEqualTo("mohamed@example.com");
	}

	@Test
	void testFindUsersByRole() {
		// Arrange: create role
		Role adminRole = new Role();
		adminRole.setName("ADMIN");
		entityManager.persist(adminRole);

		Role userRole = new Role();
		userRole.setName("USER");
		entityManager.persist(userRole);

		// Create users
		User u1 = new User();
		u1.setUsername("alice");
		u1.setEmail("alice@example.com");
		u1.setRole(adminRole);
		entityManager.persist(u1);

		User u2 = new User();
		u2.setUsername("bob");
		u2.setEmail("bob@example.com");
		u2.setRole(userRole);
		entityManager.persist(u2);

		entityManager.flush();

		// Act
		List<UserRoleProjection> admins = userRepository.findUsersByRole("ADMIN");

		// Assert
		assertThat(admins).hasSize(1);
		assertThat(admins.get(0).getUsername()).isEqualTo("alice");
		assertThat(admins.get(0).getRoleName()).isEqualTo("ADMIN");
	}

}
