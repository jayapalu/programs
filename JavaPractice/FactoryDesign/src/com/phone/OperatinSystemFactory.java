package com.phone;

/**
 * Created by jayapal_uradi on 8/8/17.
 */
public class OperatinSystemFactory {

    public OS getInstance(String str) {

        if (str.equalsIgnoreCase("android")) {
            return new Android();
        } else if (str.equalsIgnoreCase("windows")) {
            return new Windows();
        } else
            return new Ios();
    }
}
