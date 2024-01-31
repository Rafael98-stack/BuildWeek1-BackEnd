package it.be.epicode.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Tessera {
    @Id
    @GeneratedValue
    @Column(name = "numero_tessera")
    private long id;

    @Column(name = "data_rinnovo")
    private LocalDate dataRinnovo;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Tessera(){}

    public Tessera(LocalDate dataRinnovo, Utente utente) {
        this.dataRinnovo = dataRinnovo;
        this.utente = utente;
        dataScadenza = dataRinnovo.plusYears(1);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataRinnovo() {
        return dataRinnovo;
    }

    public void setDataRinnovo(LocalDate dataRinnovo) {
        this.dataRinnovo = dataRinnovo;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "Tessera{" +
                "id=" + id +
                ", dataRinnovo=" + dataRinnovo +
                ", dataScadenza=" + dataScadenza +
                ", utente=" + utente +
                '}';
    }
}