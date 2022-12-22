package dambi.accessingmongoumeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBUmeaRepository implements UmeaRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Umea> umeaCollection;

    @PostConstruct
    void init() {
        umeaCollection = client.getDatabase("gabonak").getCollection("umeak", Umea.class);
    }

    @Override
    public List<Umea> findAll() {
        return umeaCollection.find().into(new ArrayList<>());
    }

    public List<Umea> hiru_Opari_BainoGehiago() {

        List<Umea> umeak = umeaCollection.find().into(new ArrayList<>());
        List<Umea> umeak_Opari_Asko = new ArrayList<>();

        for (int i = 0; i < umeak.size(); ++i) {

            if (umeak.get(i).getOpariak().size() >= 3) {
                umeak_Opari_Asko.add(umeak.get(i));
            }
        }
        return umeak_Opari_Asko;
        // return umea.getOpariak();
    }

    @Override
    public Umea findById(String id) {
        return umeaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Umea save(Umea umea) {
        umea.setId(new ObjectId());
        umeaCollection.insertOne(umea);
        return umea;
    }

    @Override
    public long delete(String izena) {
        return umeaCollection.deleteMany(eq("izena", izena)).getDeletedCount();
    }

    @Override
    public List<String> getAllOpariakByUmeaIzena(String izena) {
        Umea umea = umeaCollection.find(eq("izena", izena)).first();
        List<String> opariak = umea.getOpariak();
        return opariak;
    }

    @Override
    public void addOpariToUmea(String izena, String opariIzena) {
        Umea umea = umeaCollection.find(eq("izena", izena)).first();
        List<String> opariak = umea.getOpariak();
        opariak.add(opariIzena);
        umeaCollection.updateOne(eq("izena", izena), new Document("$set", new Document("opariak", opariIzena)));
    }

    public String findAllPresents() {
        StringBuffer emaitza = new StringBuffer();
        umeaCollection.find().into(new ArrayList<>()).forEach((umea) -> {
            umea.getOpariak().forEach((opari) -> {
                emaitza.append(opari + ";");
            });
        });
        String returneo = ((emaitza.deleteCharAt(emaitza.length() - 1))).toString();
        return returneo;
        // return emaitza.deleteCharAt(emaitza.length() -1);
    }
}
