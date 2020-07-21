package com.zikozee.swaggerest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bcrypter {

    public static void main(String[] args) throws ParseException {
        String password = "ziko123";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        System.out.println(encryptedPassword);

        String testDate = "2015-09-02";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(testDate);
        System.out.println(date);
    }


}
