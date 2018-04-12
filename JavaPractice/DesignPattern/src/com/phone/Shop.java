package com.phone;

/**
 * Created by jayapal_uradi on 8/8/17.
 */
public class Shop {

    public static void main(String args[]) {
        //Phone p = new Phone("Android", 4, "qualcom", 5.5, 3056);
        Phone p = new PhoneBuilder().setOs("android").setBattery(3045).setProcessor("qualcom").getPhone();
        System.out.println("Phone "+p);
    }
}
