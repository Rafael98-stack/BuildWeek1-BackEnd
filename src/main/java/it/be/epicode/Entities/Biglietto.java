package it.be.epicode.Entities;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
public class Biglietto extends DocumentoViaggio {


    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, double prezzo, Emettitore emettitore, Utente utente) {
        super(dataEmissione, prezzo, emettitore, utente);
    }

    public void annullaBiglietto() {
        if (!isAnnullato()) {
            setAnnullato(true);
        }
    }

    public void vidimaBiglietto() {
        if (!isAnnullato() && getDataVidimazione() == null) {
            setAnnullato(true);
            setDataVidimazione(LocalDate.now());
        }
    }

}
