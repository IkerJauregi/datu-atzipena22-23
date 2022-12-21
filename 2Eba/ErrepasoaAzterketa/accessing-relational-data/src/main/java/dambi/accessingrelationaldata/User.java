package dambi.accessingrelationaldata;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Session> sessions = new ArrayList<>();

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
