package com.example.io.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PatternFindInFiles {

    public List<Integer> find(String filename, String pattern) {

        List<Integer> linesList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            int lineNum = 1;
            while(  (line=br.readLine())!= null ) {

                if(line.contains(pattern)) {
                    linesList.add(lineNum);
                }
                lineNum++;
            }

        }catch (Exception ex) {
            System.out.println(" Exception found");
            ex.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return linesList;
    }
}
