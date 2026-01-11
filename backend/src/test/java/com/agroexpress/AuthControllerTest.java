package com.agroexpress;

import com.agroexpress.controller.AuthController;
import com.agroexpress.model.VerificationCode;
import com.agroexpress.response.ApiResponse;
import com.agroexpress.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AuthControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testSentLoginOtp_Success() throws Exception {
        // Arrange
        VerificationCode req = new VerificationCode();
        req.setEmail("test@example.com");

        doNothing().when(authService).sentLoginOtp("test@example.com");

        // Act & Assert
        mockMvc.perform(post("/auth/sent/login-signup-otp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("otp sent"));

        verify(authService, times(1)).sentLoginOtp("test@example.com");
    }

    @Test
    void testSentLoginOtp_Exception() throws Exception {
        // Arrange
        VerificationCode req = new VerificationCode();
        req.setEmail("test@example.com");

        doThrow(new RuntimeException("Email service error")).when(authService).sentLoginOtp("test@example.com");

        // Act & Assert
        mockMvc.perform(post("/auth/sent/login-signup-otp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isInternalServerError());

        verify(authService, times(1)).sentLoginOtp("test@example.com");
    }
}