package iostreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharactersOrdezkatuz {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("xanadu.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                //if letra a bada o gaitik aldatuko du
                if(c == 97){
                    c = 111;
                }if(c == 65){
                    c = 79;
                }
                //Characteroutput artxiboan idaztendau
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}