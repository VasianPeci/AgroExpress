package com.agroexpress;

import com.agroexpress.exception.UserException;
import com.agroexpress.model.User;
import com.agroexpress.repository.UserRepository;
import com.agroexpress.service.impl.UserServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplementationTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImplementation userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindUserByEmail_UserExists() throws UserException {
        // Arrange
        String email = "test@example.com";
        User user = new User();
        user.setEmail(email);
        when(userRepository.findByEmail(email)).thenReturn(user);

        // Act
        User result = userService.findUserByEmail(email);

        // Assert
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        verify(userRepository, times(1)).findByEmail(email);
    }

    @Test
    void testFindUserByEmail_UserDoesNotExist() {
        // Arrange
        String email = "nonexistent@example.com";
        when(userRepository.findByEmail(email)).thenReturn(null);

        // Act & Assert
        UserException exception = assertThrows(UserException.class, () -> {
            userService.findUserByEmail(email);
        });
        assertEquals("user not exist with username nonexistent@example.com", exception.getMessage());
        verify(userRepository, times(1)).findByEmail(email);
    }
}