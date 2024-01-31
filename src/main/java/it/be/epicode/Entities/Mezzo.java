//package it.be.epicode.Entities;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "mezzo")
//@DiscriminatorValue("mezzo")
//public abstract class Mezzo extends Tratta {
//
//private boolean inServizio;
//
//    private LocalDate dataInizioManutenzione;
//
//    private LocalDate dataFineManutenzione;
//
//    private LocalDate dataInizioServizio;
//
//    private LocalDate dataFineServizio;
//
//    public Mezzo() {
//    }
//
//    public Mezzo(boolean inServizio, LocalDate dataInizioManutenzione, LocalDate dataFineManutenzione, LocalDate dataInizioServizio, LocalDate dataFineServizio) {
//        this.inServizio = inServizio;
//        this.dataInizioManutenzione = dataInizioManutenzione;
//        this.dataFineManutenzione = dataFineManutenzione;
//        this.dataInizioServizio = dataInizioServizio;
//        this.dataFineServizio = dataFineServizio;
//    }
//
//    public boolean isInServizio() {
//        return inServizio;
//    }
//
//    public void setInServizio(boolean inServizio) {
//        this.inServizio = inServizio;
//    }
//
//    public LocalDate getDataInizioManutenzione() {
//        return dataInizioManutenzione;
//    }
//
//    public void setDataInizioManutenzione(LocalDate dataInizioManutenzione) {
//        this.dataInizioManutenzione = dataInizioManutenzione;
//    }
//
//    public LocalDate getDataFineManutenzione() {
//        return dataFineManutenzione;
//    }
//
//    public void setDataFineManutenzione(LocalDate dataFineManutenzione) {
//        this.dataFineManutenzione = dataFineManutenzione;
//    }
//
//    public LocalDate getDataInizioServizio() {
//        return dataInizioServizio;
//    }
//
//    public void setDataInizioServizio(LocalDate dataInizioServizio) {
//        this.dataInizioServizio = dataInizioServizio;
//    }
//
//    public LocalDate getDataFineServizio() {
//        return dataFineServizio;
//    }
//
//    public void setDataFineServizio(LocalDate dataFineServizio) {
//        this.dataFineServizio = dataFineServizio;
//    }
//
//    @Override
//    public String toString() {
//        return "Mezzo{" +
//                "inServizio=" + inServizio +
//                ", dataInizioManutenzione=" + dataInizioManutenzione +
//                ", dataFineManutenzione=" + dataFineManutenzione +
//                ", dataInizioServizio=" + dataInizioServizio +
//                ", dataFineServizio=" + dataFineServizio +
//                '}';
//    }
//}
