package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Towar {


    public Towar() {
        this.cena = cena;
        this.nazwa = nazwa;
        this.dataWydania = new GregorianCalendar().getTime();
    }

    public Towar(double cena, String nazwa) {
        this();
        this.cena = cena;
        this.nazwa = nazwa;
    }

    public Towar(double cena, String nazwa, int rok, int miesiac, int dzien) {
        this(cena, nazwa);
        GregorianCalendar kalendarz = new GregorianCalendar(rok, miesiac - 1, dzien);
        dataWydania = kalendarz.getTime();
    }
    public double pobierzCene(){
        return this.cena;
    }
    public String pobierzNazwe(){
        return this.nazwa;
    }
    public Date pobierzDate(){
        return this.dataWydania;
    }
    public void ustawCene(){
        this.cena = cena;
    }
    public void ustawNazwe(){
        this.nazwa = nazwa;
    }
    public void ustawDate(int r, int m, int dz){
        GregorianCalendar kalendarz = new GregorianCalendar(r, m -1, dz);
        this.dataWydania = kalendarz.getTime();
    }

    public void ustawDate(Date data ){
        this.dataWydania = data;
    }

    @Override
    public String toString() {
        GregorianCalendar kal = new GregorianCalendar();
        kal.setTime(this.dataWydania);
        return this.cena + " zł; nazwa: " + this.nazwa + " " + kal.get(Calendar.YEAR) + " " + " rok" + kal.get(Calendar.MONTH) + " " + " miesiac" +
                kal.get(Calendar.DAY_OF_MONTH) + " " + " dzien";
    }
    static public void zapiszDoPliku(Towar[] towars, PrintWriter outS){
        outS.println(towars.length);
        GregorianCalendar kal = new GregorianCalendar();
        for (int i = 0; i < towars.length; i++) {
            kal.setTime(towars[i].pobierzDate());
            outS.println(towars[i].pobierzCene()+"|"+towars[i].pobierzNazwe()+"|"+kal.get(Calendar.YEAR) + "|" + ((kal.get(Calendar.MONTH))+1) + "|" +
                    kal.get(Calendar.DAY_OF_MONTH) + "|");
        }

    }
    public static Towar[] odczytajZPliku(BufferedReader inS) throws IOException {
        int dl = Integer.parseInt(inS.readLine());
        Towar[] towar = new Towar[dl];
        for (int i = 0; i < dl; i++) {
            String linia = inS.readLine();
            StringTokenizer tokeny = new StringTokenizer(linia, "|");
            double cena = Double.parseDouble(tokeny.nextToken());
            String nazwa = tokeny.nextToken();
            int rok = Integer.parseInt(tokeny.nextToken());
            int miesiac = Integer.parseInt(tokeny.nextToken());
            int dzien = Integer.parseInt(tokeny.nextToken());
            towar[i] = new Towar(cena, nazwa, rok, miesiac, dzien);
        }
        return towar;
    }

    private double cena;
    private String nazwa;
    private Date dataWydania;
}
