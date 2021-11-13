package designpattern;

import java.lang.System;

public class Singleton {


    public static void main(String args[]) {

        System.out.println("This is a singleton example class");
        //directInstance();
        threadInstance();
    }

    public static void directInstance() {
        System.out.println("This is a singleton example directInstance");

        SingletonClass s = SingletonClass.getInstance();
        s.getmethod();
        SingletonClass s2 = SingletonClass.getInstance();
        s2.getmethod();
    }

    public static void threadInstance() {
        System.out.println("This is a singleton example threadInstance");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass s = SingletonClass.getInstance();
                s.getmethod();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SingletonClass s = SingletonClass.getInstance();
                s.getmethod();
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

class SingletonClass {

    int i=10;
    static SingletonClass s = null;
    private SingletonClass () {
        System.out.println("SingletonClass constructor visited");
    }


    public static  SingletonClass getInstance() {

        if (s == null) {
            synchronized (SingletonClass.class) {
                if (s == null) {
                    s = new SingletonClass();
                }
            }
        }
        return s;
    }

    public void getmethod() {
        System.out.printf("singletonclass getmethod i=%d\n", i);
    }
}