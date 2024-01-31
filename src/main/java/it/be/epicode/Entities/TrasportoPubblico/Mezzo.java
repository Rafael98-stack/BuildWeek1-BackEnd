package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mezzo")
@DiscriminatorValue("mezzo")
public abstract class Mezzo extends Tratta {

private boolean inServizio;

    private Date dataInizioManutenzione;

    private Date dataFineManutenzione;

    private Date dataInizioServizio;

    private Date dataFineServizio;

    public Mezzo() {
    }

    public Mezzo(String partenza, String capolinea, long tempoMedioPercorso, boolean inServizio, Date dataInizioManutenzione, Date dataFineManutenzione, Date dataInizioServizio, Date dataFineServizio) {
        super(partenza, capolinea, tempoMedioPercorso);
        this.inServizio = inServizio;
        this.dataInizioManutenzione = dataInizioManutenzione;
        this.dataFineManutenzione = dataFineManutenzione;
        this.dataInizioServizio = dataInizioServizio;
        this.dataFineServizio = dataFineServizio;
    }

    public boolean isInServizio() {
        return inServizio;
    }

    public void setInServizio(boolean inServizio) {
        this.inServizio = inServizio;
    }

    public Date getDataInizioManutenzione() {
        return dataInizioManutenzione;
    }

    public void setDataInizioManutenzione(Date dataInizioManutenzione) {
        this.dataInizioManutenzione = dataInizioManutenzione;
    }

    public Date getDataFineManutenzione() {
        return dataFineManutenzione;
    }

    public void setDataFineManutenzione(Date dataFineManutenzione) {
        this.dataFineManutenzione = dataFineManutenzione;
    }

    public Date getDataInizioServizio() {
        return dataInizioServizio;
    }

    public void setDataInizioServizio(Date dataInizioServizio) {
        this.dataInizioServizio = dataInizioServizio;
    }

    public Date getDataFineServizio() {
        return dataFineServizio;
    }

    public void setDataFineServizio(Date dataFineServizio) {
        this.dataFineServizio = dataFineServizio;
    }

    @Override
    public String toString() {
        return "Mezzo{" +
                "inServizio=" + inServizio +
                ", dataInizioManutenzione=" + dataInizioManutenzione +
                ", dataFineManutenzione=" + dataFineManutenzione +
                ", dataInizioServizio=" + dataInizioServizio +
                ", dataFineServizio=" + dataFineServizio +
                '}';
    }
}
