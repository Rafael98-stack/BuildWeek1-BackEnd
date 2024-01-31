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
        dataFineServizio = this.dataFineServizio;
        dataInizioServizio = this.dataInizioServizio;
        dataFineManutenzione = this.dataFineManutenzione;
        dataInizioManutenzione = this.dataInizioManutenzione;
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

    public void setInServizioInManutenzione(String mese,int anno){
        int annoSeguente = anno + 1;
        int meseIM = 0;
        int giornoIM = 0;
        int meseFM = 0;
        int giornoFM = 0;
        int meseIS = 0;
        int giornoIS = 0;
        int meseFS = 0;
        int giornoFS = 0;

        switch (mese) {
            case "Gennaio" :
      meseIM = 0;
      giornoIM = 1;
      meseFM = meseIM;
      giornoFM = 31;
                 meseIS = meseFM + 1;
                 giornoIS = 1;
                 meseFS = meseIM - 1 ;
                 giornoFS = 31 ;
this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Febbraio":
                meseIM = 1;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
            break;
            case "Marzo":
                meseIM = 2;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Aprile":
                meseIM = 3;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Maggio":
                meseIM = 4;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Giugno":
                meseIM = 5;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Luglio":
                meseIM = 6;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Agosto":
                meseIM = 7;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Settembre":
                meseIM = 8;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Ottobre":
                meseIM = 9;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Novembre":
                meseIM = 10;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
            case "Dicembre":
                meseIM = 11;
                giornoIM = 1;
                meseFM = meseIM;
                giornoFM = 31;
                meseIS = meseFM + 1;
                giornoIS = 1;
                meseFS = meseIM - 1 ;
                giornoFS = 31 ;
                this.dataInizioManutenzione = new Date(anno,meseIM,giornoIM);
                this.dataFineManutenzione = new Date(anno,meseFM,giornoFM);
                this.dataInizioServizio = new Date(anno,meseIS,giornoIS);
                this.dataFineServizio = new Date(annoSeguente,meseFS,giornoFS);
                break;
        }
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
