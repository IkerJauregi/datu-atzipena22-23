package dambi.mongoumeak.model;

import java.util.List;

public class Umea {
    private Object id;
    private String izena;
    private List<String> opariak;

    public Umea(Object id, String izena, List<String> opariak) {
        this.id = id;
        this.izena = izena;
        this.opariak = opariak;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public List<String> getOpariak() {
        return opariak;
    }

    public void setOpariak(List<String> opariak) {
        this.opariak = opariak;
    }

    @Override
    public String toString() {
        return "Umea [id=" + id + ", izena=" + izena + ", opariak=" + opariak + "]";
    }
}
