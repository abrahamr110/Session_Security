package com.es.seguridadsession.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashUtil {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
