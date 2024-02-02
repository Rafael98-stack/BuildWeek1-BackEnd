package it.be.epicode.Entities;

import it.be.epicode.Entities.TrasportoPubblico.Mezzo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "biglietti")
public class Biglietto extends DocumentoViaggio {

    @ManyToOne
    @JoinColumn(name = "mezzo_id")
    private Mezzo mezzo;


    public Biglietto() {
    }

    public Biglietto(LocalDate dataEmissione, double prezzo, Emettitore emettitore, Utente utente) {
        super(dataEmissione, prezzo, emettitore, utente);
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
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
