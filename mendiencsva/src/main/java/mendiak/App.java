package mendiak;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.FileReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        // I/O Stream
        FileInputStream input = null;
        FileInputStream output = null;
        // Menua
        Scanner in = new Scanner(System.in);
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Mendien zerrenda ikusi");
            System.out.println("2.- Mendirik altuena bistaratu");
            System.out.println("3.- Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    mendienZerrenda();
                    break;
                case 2:
                    mendirikAltuena();
                    break;
                case 3:
                    mendiakEsportatu();
                case 4:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 4);
        in.next();
    }

    public static void mendienZerrenda() {
        Scanner s = null;
        try {
        s = new Scanner(new BufferedReader(new FileReader("Mendiak.csv")));
        s.useDelimiter(";");
        // Mientras se escanee algo "nuevo" lo imprimira
        while(s.hasNext()){
            System.out.print(s.next() + ",");
        }
        } catch (Exception e) {
        // TODO: handle exception
        System.out.println(e);
        }
    }
    public static void mendirikAltuena() {
        // 
    }

    public static void mendiakEsportatu() {

    }
}