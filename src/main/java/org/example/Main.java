package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Towar[] towars = new Towar[3];

         towars[0] = new Towar();
         towars[1] = new Towar(29.0, "Video Kurs Java");
         towars[2] = new Towar(39.90, "Video Kurs C++", 2008, 11, 21 );

         try{

             PrintWriter writer = new PrintWriter(new FileWriter("baza.txt"));

                Towar.zapiszDoPliku(towars, writer);
             writer.close();

             BufferedReader bufferedReader = new BufferedReader(new FileReader("baza.txt"));
             Towar[] towar2 = Towar.odczytajZPliku(bufferedReader);

             for (int i = 0; i < towar2.length; i++) {
                 System.out.println(towar2[i]);

             }

             bufferedReader.close();

         }catch (IOException e){
             System.out.println(e.getMessage());
         }




    }
}