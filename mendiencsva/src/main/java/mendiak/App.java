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
 * Kodea ez dago optimizatuta beraz funtzionatzen duenean dena optimizatu
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
        int saltuak = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("Mendiak.csv")));
            s.useDelimiter(";");
            // Mientras se escanee algo "nuevo" lo imprimira
            while (s.hasNext()) {
                if (saltuak < 2) {
                    System.out.print(s.next() + " ");
                } else {
                        
                        // https://reactgo.com/java-remove-last-comma-of-string/#:~:text=We%20remove%20the%20last%20comma,last%20index%20that%20is%20string.
                        System.out.print(s.next() + ",");

                        // String moztu = s.next();
                        // moztu = moztu.substring(0, moztu.length() -1);
                        // System.out.print(moztu);
                }
                saltuak++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void mendirikAltuena() {
        ArrayList<String> mendiak = new ArrayList<>();
    }

    public static void mendiakEsportatu() {

    }
}