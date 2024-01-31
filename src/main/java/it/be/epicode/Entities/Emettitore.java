package it.be.epicode.Entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emettitore")
public abstract class Emettitore {

    @Id
    @GeneratedValue
    private int id;

    public Emettitore(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Emettitore{" +
                "id=" + id +
                '}';
    }
}