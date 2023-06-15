package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Towar[] towars = new Towar[3];

         towars[0] = new Towar();
         towars[1] = new Towar(29.0, "Video Kurs Java");
         towars[2] = new Towar(39.90, "Video Kurs C++", 2008, 11, 21 );

         try{



         }catch (IOException e){
             System.out.println(e.getMessage());
         }




    }
}