package it.be.epicode.Entities.Biglietteria.TrasportoPubblico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("auto-bus")
public class Auto_Bus extends Mezzo {
    private String nomeVeicolo;
    private TipologiaTrasporto tipologiaTrasporto=TipologiaTrasporto.AUTO_BUS;

    private String targa;

    private int capienzaEffettiva = 40;

    private int capienzaAttuale;


    public Auto_Bus() {}

    public Auto_Bus(boolean inServizio, LocalDate dataInizioManutenzione, LocalDate dataFineManutenzione, LocalDate dataInizioServizio, LocalDate dataFineServizio, String nomeVeicolo, TipologiaTrasporto tipologiaTrasporto) {
        super(inServizio, dataInizioManutenzione, dataFineManutenzione, dataInizioServizio, dataFineServizio);
        this.nomeVeicolo = nomeVeicolo;
        this.tipologiaTrasporto = tipologiaTrasporto;
    }

    public String getNomeVeicolo() {
        return nomeVeicolo;
    }

    public void setNomeVeicolo(String nomeVeicolo) {
        this.nomeVeicolo = nomeVeicolo;
    }

    public TipologiaTrasporto getTipologiaTrasporto() {
        return tipologiaTrasporto;
    }

    public void setTipologiaTrasporto(TipologiaTrasporto tipologiaTrasporto) {
        this.tipologiaTrasporto = tipologiaTrasporto;
    }

    public int getCapienzaEffettiva() {
        return capienzaEffettiva;
    }

    public void setCapienzaEffettiva(int capienzaEffettiva) {
        this.capienzaEffettiva = capienzaEffettiva;
    }

    public int getCapienzaAttuale() {
        return capienzaAttuale;
    }

    public void setCapienzaAttuale(int capienzaAttuale) {
        this.capienzaAttuale = capienzaAttuale;
    }

    @Override
    public String toString() {
        return "Auto_Bus{" +
                "nomeVeicolo='" + nomeVeicolo + '\'' +
                ", tipologiaTrasporto=" + tipologiaTrasporto +
                ", capienzaEffettiva=" + capienzaEffettiva +
                ", capienzaAttuale=" + capienzaAttuale +
                '}';
    }
}
