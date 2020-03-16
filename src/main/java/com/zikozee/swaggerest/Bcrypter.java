package com.zikozee.swaggerest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypter {

    public static void main(String[] args) {
        String password = "ziko123";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        System.out.println(encryptedPassword);
    }
}
