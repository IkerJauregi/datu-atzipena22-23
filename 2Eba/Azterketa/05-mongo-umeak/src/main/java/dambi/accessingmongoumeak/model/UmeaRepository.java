package dambi.accessingmongoumeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UmeaRepository {
    List<Umea> findAll();
    Umea findById(String id);
    Umea save(Umea person);
    long delete(String izena);
    List<String> getAllOpariakByUmeaIzena(String izena);
    void addOpariToUmea(String izena, String opariak);
    List<Umea> hiru_Opari_BainoGehiago();
}
