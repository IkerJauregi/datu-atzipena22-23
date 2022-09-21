package iostreams;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLinesZenbakiekin {
    public static void main(String[] args) throws IOException {

        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("xanadu.txt"));
            out = new PrintWriter(new FileWriter("outagain.txt"));
            
            String hilera;
            int hileraZen = 1;
            
            while ((hilera = in.readLine()) != null) {
                out.println(hileraZen + " " + hilera);
                hileraZen++;
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
