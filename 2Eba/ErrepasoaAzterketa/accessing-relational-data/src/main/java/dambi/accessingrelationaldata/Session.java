package dambi.accessingrelationaldata;

import jakarta.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Eguna")
    private String eguna;

    @Column(name = "Iraupena")
    private String iraupena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEguna() {
        return eguna;
    }

    public void setEguna(String eguna) {
        this.eguna = eguna;
    }

    public String getIraupena() {
        return iraupena;
    }

    public void setIraupena(String iraupena) {
        this.iraupena = iraupena;
    }

    public User getErabiltzailea() {
        return user;
    }

    public void setErabiltzailea(User user) {
        this.user = user;
    }
}
