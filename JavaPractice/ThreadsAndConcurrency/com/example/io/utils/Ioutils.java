package com.example.io.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ioutils {

    public static void copyFile(String srcFile, String destFile) throws IOException {

        FileInputStream fin = new FileInputStream(srcFile);
        FileOutputStream fout = new FileOutputStream(destFile);

        System.out.println("copying from file "+srcFile +" ---> "+destFile);
        copy(fin, fout);

        fin.close();
        fout.close();
    }

    public static void copy(FileInputStream src, FileOutputStream dest) throws IOException {

        int value;
        while((value = src.read()) != -1) {
            dest.write(value);
        }

        System.out.println("copy started from thread");
    }


}
