package mendiak;

import java.util.Scanner;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.PrintStream;
// import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    // mendienZerrenda moduan mendien zerrenda atera
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
        } catch (Exception e) {

        }
        int tallest = 0;
        int tallestID = 0;
        for (int i = 3; i < mendienZerrenda.size(); i += 3) { // grabs groups of 3, also skips the title
            if (Integer.parseInt(mendienZerrenda.get(i + 1)) > tallest) {
                tallest = Integer.parseInt(mendienZerrenda.get(i + 1));
                tallestID = i;
            }
        }
        System.out.printf("Mendi altuena %s da %d-eko altuerarekin. \n", mendienZerrenda.get(tallestID), tallest);
    }

    // Araba.csv Bizkaia.csv eta Gipuzkoa.csv atera banan banan
    public static void mendiakEsportatu() throws IOException {
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
        } catch (Exception e) {
        }
        ArrayList<String> araba = new ArrayList<>();
        ArrayList<String> bizkaia = new ArrayList<>();
        ArrayList<String> gipuzkoa = new ArrayList<>();
        for (int i = 3; i < mendienZerrenda.size(); i += 3) { // grabs groups of 3, also skips the title
            switch (mendienZerrenda.get(i + 2).toLowerCase()) { // separates into arraylists, adds names
                case "araba":
                    araba.add(mendienZerrenda.get(i) + "; " + mendienZerrenda.get(i+1) + "; " + mendienZerrenda.get(i+2));
                case "bizkaia":
                    bizkaia.add(mendienZerrenda.get(i) + "; " + mendienZerrenda.get(i+1)  + "; " + mendienZerrenda.get(i+2));
                case "gipuzkoa":
                    gipuzkoa.add(mendienZerrenda.get(i) + "; " + mendienZerrenda.get(i+1)  + "; " + mendienZerrenda.get(i+2));
            }
        }
        sartuCSV("araba.csv" , araba);
        sartuCSV("gipuzkoa.csv" , gipuzkoa);
        sartuCSV("bizkaia.csv" , bizkaia);
    }
    public static void sartuCSV(String fitxeroIzena, ArrayList<String> probintzia) throws IOException{
        File csvFitxategia = new File(fitxeroIzena);
        try(PrintWriter csvWriter = new PrintWriter(new FileWriter(csvFitxategia))){
            for(int i = 1; i<probintzia.size(); i++){
                csvWriter.println(probintzia.get(i));
            }
            System.out.println(fitxeroIzena + " esportatu");
        }
    }
}
