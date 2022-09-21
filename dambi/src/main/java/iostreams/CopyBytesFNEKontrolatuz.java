package iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
CopyBytes programaren berdiña egiten du baina fitxategia irakurtzen duenean
errorea ematen du eta horregaitik catch{} barnean FileNotFoundException dago
eta hori errorea ematen badu fallo mezu bat bidaliko du.
*/
public class CopyBytesFNEKontrolatuz {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xnadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
            // Artxiboa ez bada aurkitzen bertan sartuko da.
        } catch (FileNotFoundException exception) {
            // throw new FileNotFoundException("fitxategia ez da aurkitu.");
            System.out.println("Fitxategia ez da aurkitu");
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}