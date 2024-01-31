package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("auto-bus")
public class Auto_Bus extends Mezzo {
    private String nomeVeicolo;
    private TipologiaTrasporto tipologiaTrasporto= TipologiaTrasporto.AUTO_BUS;

    private String targa;

    private int capienzaEffettiva = 40;

    private int capienzaAttuale;

    public Auto_Bus() {}

    public Auto_Bus(String partenza, String capolinea, long tempoMedioPercorso, boolean inServizio, Date dataInizioManutenzione, Date dataFineManutenzione, Date dataInizioServizio, Date dataFineServizio, String nomeVeicolo, String targa, int capienzaAttuale) {
        super(partenza, capolinea, tempoMedioPercorso, inServizio, dataInizioManutenzione, dataFineManutenzione, dataInizioServizio, dataFineServizio);
        this.nomeVeicolo = nomeVeicolo;
        this.targa = targa;
        this.capienzaAttuale = capienzaAttuale;
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
