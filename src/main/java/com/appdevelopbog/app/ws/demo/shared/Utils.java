package com.appdevelopbog.app.ws.demo.shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    public final Random random = new SecureRandom();
    public final String nums = "0123456789";

    public String generateAid(int length){
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder();
        for(int i=0;i<length;i++){
            returnValue.append(nums.charAt(random.nextInt(nums.length())));
        }
        return new String(returnValue);
    }
}
