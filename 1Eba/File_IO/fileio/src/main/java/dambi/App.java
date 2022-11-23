package dambi;

import java.io.File;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aukera = 1;

        while (aukera != 0) {
            System.out.println("Path MENUA");
            System.out.println("==============================");
            System.out.println("1. Zer zoaz deskribatzera?");
            System.out.println("2. Fitxategi berri bat sortu");
            System.out.println("3. Irten");
            System.out.println();
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = sc.nextInt();
            System.out.println();

            switch (aukera) {
                case 1:
                    pathBilatu();
                    break;
                case 2:
                    fitxategiaSortu();
                    break;
                case 3:
                    break;
            }
        }
    }

    // Sartutako path-a ordenagailuan dagoen edo ez begiratuko du.
    public static void pathBilatu() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Sartu path absoluto bat:");
        String path = sc.next();
        File fitxategiTemp = new File(path);
        sc.close();

        if (fitxategiTemp.exists()) {
            System.out.println("Fitxategia badago.");
        } else if (fitxategiTemp.isDirectory()) {
            System.out.println("Dana egoki doa.");
        } else {
            System.out.println("Fitxategia ez da aurkitu");
        }
    }

    // Sartutako path batean fitxategi bat sortuko du.
    public static void fitxategiaSortu() {
        Scanner sc = new Scanner(System.in);
        String karpeta, fitxategia, deskribapena;

        System.out.printf("Zer zoaz deskribatzera?");
        karpeta = sc.next();
        System.out.printf("Sortu nahi duzun fitxategiaren izena");
        fitxategia = sc.next();
        System.out.printf("Idatzi fitxategiaren informazioa");
        deskribapena = sc.next();
    }
}
