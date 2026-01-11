package com.agroexpress;

import com.agroexpress.exception.SellerException;
import com.agroexpress.model.Cart;
import com.agroexpress.model.User;
import com.agroexpress.repository.CartRepository;
import com.agroexpress.repository.UserRepository;
import com.agroexpress.request.SignupRequest;
import com.agroexpress.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CartRepository cartRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // =========================
    // SUCCESS CASE
    // =========================
    @Test
    void testCreateUser_NewUser_Success() throws SellerException {
        SignupRequest req = new SignupRequest();
        req.setEmail("test@example.com");
        req.setFullName("Test User");

        when(userRepository.findByEmail("test@example.com")).thenReturn(null);
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        when(cartRepository.save(any(Cart.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        String token = authService.createUser(req);

        assertNotNull(token);
        verify(userRepository).save(any(User.class));
        verify(cartRepository).save(any(Cart.class));
    }

    // =========================
    // EXCEPTION CASE: USER EXISTS
    // =========================
    @Test
    void testCreateUser_ExistingUser_ThrowsSellerException() {
        SignupRequest req = new SignupRequest();
        req.setEmail("existing@example.com");
        req.setFullName("Existing User");

        User existingUser = new User();
        existingUser.setEmail("existing@example.com");

        when(userRepository.findByEmail("existing@example.com"))
                .thenReturn(existingUser);

        assertThrows(SellerException.class, () -> authService.createUser(req));

        verify(userRepository, never()).save(any(User.class));
        verify(cartRepository, never()).save(any(Cart.class));
    }

    // =========================
    // EXCEPTION CASE: USER SAVE FAILS
    // =========================
    @Test
    void testCreateUser_UserSaveFails_ThrowsSellerException() {
        SignupRequest req = new SignupRequest();
        req.setEmail("fail@example.com");
        req.setFullName("Fail User");

        when(userRepository.findByEmail(any())).thenReturn(null);
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");

        when(userRepository.save(any(User.class)))
                .thenThrow(new SellerException("Database error"));

        assertThrows(SellerException.class, () -> authService.createUser(req));

        verify(cartRepository, never()).save(any(Cart.class));
    }

    // =========================
    // EXCEPTION CASE: CART SAVE FAILS
    // =========================
    @Test
    void testCreateUser_CartSaveFails_ThrowsSellerException() {
        SignupRequest req = new SignupRequest();
        req.setEmail("cartfail@example.com");
        req.setFullName("Cart Fail");

        when(userRepository.findByEmail(any())).thenReturn(null);
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        when(cartRepository.save(any(Cart.class)))
                .thenThrow(new SellerException("Cart save failed"));

        assertThrows(SellerException.class, () -> authService.createUser(req));
    }
}
