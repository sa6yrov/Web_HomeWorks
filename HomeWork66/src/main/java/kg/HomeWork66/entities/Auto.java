package kg.HomeWork66.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auto")
public class Auto {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "inn")
    private String inn;

    public Auto(Integer id, String inn) {
        this.id = id;
        this.inn = inn;
    }

    public Auto() {
    }

    @Override
    public String toString() {
        return "id: " + id + " | inn: " + inn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
