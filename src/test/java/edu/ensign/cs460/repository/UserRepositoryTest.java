package edu.ensign.cs460.repository;

import edu.ensign.cs460.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

// This class is used to test the UserRepository class
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    // Mock instance of UserRepository
    @Mock
    private UserRepository userRepository;

    // Test case for findByUsername method in UserRepository
    @Test
    public void testFindByUsername() {
        // Given: Set up the conditions for the test
        User mockUser = new User();
        mockUser.setUsername("john_doe");
        mockUser.setEmail("john@example.com");
        mockUser.setPassword("encryptedPassword");
        mockUser.setFullName("John Doe");

        // Define the behavior of the mock object
        when(userRepository.findByUsername("john_doe")).thenReturn(Optional.of(mockUser));

        // When: Execute the method under test
        Optional<User> found = userRepository.findByUsername("john_doe");

        // Then: Check the results
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getUsername()).isEqualTo("john_doe");
        assertThat(found.get().getEmail()).isEqualTo("john@example.com");
        assertThat(found.get().getFullName()).isEqualTo("John Doe");
    }

    // Test case for findByEmail method in UserRepository
    @Test
    public void testFindByEmail() {
        // Given: Set up the conditions for the test
        User mockUser = new User();
        mockUser.setUsername("jane_doe");
        mockUser.setEmail("jane@example.com");
        mockUser.setPassword("encryptedPassword");
        mockUser.setFullName("Jane Doe");

        // Define the behavior of the mock object
        when(userRepository.findByEmail("jane@example.com")).thenReturn(Optional.of(mockUser));

        // When: Execute the method under test
        Optional<User> found = userRepository.findByEmail("jane@example.com");

        // Then: Check the results
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getUsername()).isEqualTo("jane_doe");
        assertThat(found.get().getEmail()).isEqualTo("jane@example.com");
        assertThat(found.get().getFullName()).isEqualTo("Jane Doe");
    }
}
