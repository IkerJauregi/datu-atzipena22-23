package jsonfiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.sound.sampled.SourceDataLine;

public class JsonFitxategiaSortu {
    public static void main(String[] args) throws FileNotFoundException {
        JsonObject model = Json.createObjectBuilder()
        .add("firstName", "Iker2")
        .add("lastName", "Jauregi")
        .add("age", 21)
        .add("streetAddress", "100 Internet Dr")
        .add("city", "JavaTown")
        .add("state", "JA")
        .add("postalCode", "12345")
        .add("phoneNumbers", Json.createArrayBuilder()
           .add(Json.createObjectBuilder()
              .add("type", "mobile")
              .add("number", "111-111-1111"))
           .add(Json.createObjectBuilder()
              .add("type", "home")
              .add("number", "222-222-2222")))
        .build();
        try(JsonWriter jsonWriter = Json.createWriter(new FileOutputStream("./src/data/Irteera.json"))) {
            jsonWriter.writeObject(model);
        }
    }
}
