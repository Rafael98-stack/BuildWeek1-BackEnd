package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("tram")
public class Tram extends Mezzo {
    private String nomeVeicolo;
    private String tipologiaTrasporto= TipologiaTrasporto.TRAM.toString();

    public Tram() {
    }

    public Tram(String nomeVeicolo) {
        this.nomeVeicolo = nomeVeicolo;
    }

    public String getNomeVeicolo() {
        return nomeVeicolo;
    }

    public void setNomeVeicolo(String nomeVeicolo) {
        this.nomeVeicolo = nomeVeicolo;
    }

    public String getTipologiaTrasporto() {
        return tipologiaTrasporto;
    }

    public void setTipologiaTrasporto(String  tipologiaTrasporto) {
        this.tipologiaTrasporto = tipologiaTrasporto;
    }

    @Override
    public String toString() {
        return "Tram{" +
                "nomeVeicolo='" + nomeVeicolo + '\'' +
                ", tipologiaTrasporto=" + tipologiaTrasporto +
                '}';
    }
}
