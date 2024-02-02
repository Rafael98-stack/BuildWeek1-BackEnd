package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "rivenditore_autorizzato")
public class Rivenditore extends Emettitore{

    @OneToMany(mappedBy = "emettitore")
    private List<DocumentoViaggio> documentiViaggio;
    public Rivenditore(){}


}
