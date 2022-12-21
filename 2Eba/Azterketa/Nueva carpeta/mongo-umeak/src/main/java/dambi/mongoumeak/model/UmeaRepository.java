package dambi.mongoumeak.model;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
//TODO gogoratu ez dela class interface baizik
public interface UmeaRepository {
    List<Umea> findAll();
    Umea findById(String id);
    Umea save(Umea person);
    long delete(String izena);
    List<String> getAllOpariakByUmeaIzena(String izena);
    void addOpariToUmea(String izena, String opariak);

}
