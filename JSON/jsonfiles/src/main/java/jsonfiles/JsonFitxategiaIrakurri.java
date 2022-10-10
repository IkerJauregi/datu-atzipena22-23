package jsonfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
/**
 * Hello world!
 *
 */
public class JsonFitxategiaIrakurri 
{
    public static void main( String[] args ){
    JsonReader reader;
    
        try{
            System.out.println(new File("").getAbsolutePath());
            reader=Json.createReader(new FileReader("./src/data/test.json"));
            JsonStructure jsonst=reader.read();
            System.out.println(jsonst);
        }catch(FileNotFoundException e){
            System.out.println("Fitxategia ez da aurkitu");
        }
    }
}
