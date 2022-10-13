package mendienfitxategia.pojoak;

public class Mendia {
    private int id, altuera;
    private String mendia, probintzia;

    public Mendia(int id, int altuera, String mendia, String probintzia) {
        this.id = id;
        this.altuera = altuera;
        this.mendia = mendia;
        this.probintzia = probintzia;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAltuera() {
        return altuera;
    }
    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }
    public String getMendia() {
        return mendia;
    }
    public void setMendia(String mendia) {
        this.mendia = mendia;
    }
    public String getProbintzia() {
        return probintzia;
    }
    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }
    @Override
    public String toString() {
        return "Mendia [id=" + id + ", altuera=" + altuera + ", mendia=" + mendia + ", probintzia=" + probintzia + "]";
    }

    
}
