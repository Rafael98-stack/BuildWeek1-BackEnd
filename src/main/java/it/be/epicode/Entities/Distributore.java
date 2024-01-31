package it.be.epicode.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "distributore_automatico")
public class Distributore extends Emettitore {

    @Column(name = "in_funzione")
    private boolean inFunzione;

    @OneToMany(mappedBy = "emettitore")
    private List<DocumentoViaggio> documentiViaggio;

    public Distributore(){}

    public Distributore(boolean inFunzione) {
        this.inFunzione = inFunzione;
    }

    public boolean isInFunzione() {
        return inFunzione;
    }

    public void setInFunzione(boolean inFunzione) {
        this.inFunzione = inFunzione;
    }

    @Override
    public String toString() {
        return "Distributore{" +
                "inFunzione=" + inFunzione +
                "} " + super.toString();
    }
}



