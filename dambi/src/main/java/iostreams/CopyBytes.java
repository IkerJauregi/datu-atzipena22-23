package iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Programa honek xanadu.txt fitxategia irakurtzen du eta outgain.txt fitxategian idazten du
public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            // FileInputStream fitxategiaren bytak irakurtzen ditu.
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
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