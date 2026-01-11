package com.agroexpress.service;


import com.agroexpress.exception.SellerException;
import com.agroexpress.exception.UserException;
import com.agroexpress.request.LoginRequest;
import com.agroexpress.request.SignupRequest;
import com.agroexpress.response.AuthResponse;
import jakarta.mail.MessagingException;

public interface AuthService {
    void sentLoginOtp(String email) throws UserException, MessagingException;
    String createUser(SignupRequest req) throws SellerException;
    AuthResponse signin(LoginRequest req) throws SellerException;

}


