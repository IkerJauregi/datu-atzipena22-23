package mendiak;

import java.util.Scanner;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.PrintStream;
// import java.io.Reader;
import java.io.FileReader;

/**
 * Kodea ez dago optimizatuta beraz funtzionatzen duenean dena optimizatu
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        // I/O Stream

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

    // Taula moduan mendien zerrenda atera
    public static void mendienZerrenda() {
        // Scanner mendiak;
        String lerroa;
        ArrayList<String> mendienZerrenda = new ArrayList<>();
        try {
            FileReader fitxategia = new FileReader("Mendiak.csv");
            // Guarda el fichero en la memoria temporal
            BufferedReader buffer = new BufferedReader(fitxategia);
            lerroa = buffer.readLine();

            // Lee toda la linea y cuando encuentra un null entra aqui
            while (lerroa != null) {
                // Añade cada linea al array llamada gehitu
                String[] gehitu;
                // Vuelve a leer la linea y separa los datos
                gehitu = lerroa.split(";");
                // Vuelve a juntar todos los datos
                Collections.addAll(mendienZerrenda, gehitu);
                lerroa = buffer.readLine();
            }
            // Ahora vamos a imprimir
            for (int i = 0; i < mendienZerrenda.size(); i += 3) {
                for (int j = 0; j <= 2; j++) {
                    System.out.printf("%18s", mendienZerrenda.get(i + j));
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Mendi altuenaren izena atera
    public static void mendirikAltuena() {

    }

    // Araba.csv Bizkaia.csv eta Gipuzkoa.csv atera banan banan
    public static void mendiakEsportatu() {
        ArrayList<String> bizkaiaMendiak = new ArrayList<String>();
        ArrayList<String> gipuzkoaMendiak = new ArrayList<String>();
        ArrayList<String> arabaMendiak = new ArrayList<String>();

    }
}