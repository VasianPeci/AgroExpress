package com.agroexpress.service;

import com.agroexpress.model.VerificationCode;

public interface VerificationService {
    VerificationCode createVerificationCode(String otp, String email);
}


