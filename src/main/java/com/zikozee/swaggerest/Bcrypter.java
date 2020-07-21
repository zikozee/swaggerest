package com.zikozee.swaggerest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
public class Bcrypter {

    public static void main(String[] args) throws ParseException {
        String password = "ziko123";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(password);
        log.info(encryptedPassword);

        String testDate = "2015-09-02";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(testDate);
        log.info(" Date >>>>>" + date + "<<<<<<");
    }


}
