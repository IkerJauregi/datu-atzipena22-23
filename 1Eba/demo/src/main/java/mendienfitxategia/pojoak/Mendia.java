package mendienfitxategia.pojoak;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = { "mendia", "altuera", "probintzia" })
@XmlRootElement(name = "Mendia")

public class Mendia {
    String mendia;
    int altuera;
    String probintzia;
    public String getMendia() {
        return mendia;
    }
    @XmlElement(name = "Mendia")
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }
    public int getAltuera() {
        return altuera;
    }
    @XmlElement(name = "Altuera")
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }
    public String getProbintzia() {
        return probintzia;
    }
    @XmlElement(name = "Probintzia")
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer("Mendia: " + getMendia() + "\n");
        str.append("Altuera: " + getAltuera() + "\n");
        str.append("Probintzia: " + getProbintzia() + "\n");
        return str.toString();
    }
}
