package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documento_viaggio")
@NamedQueries({
        @NamedQuery(
                name = "Biglietto.numeroTotale",
                query = "SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :startDate AND :endDate"
        ),
        @NamedQuery(
                name = "Abbonamento.numeroTotale",
                query = "SELECT COUNT(a) FROM Abbonamento a WHERE a.dataEmissione BETWEEN :startDate AND :endDate"
        ),
        @NamedQuery(
                name = "Biglietto.numeroTotaleByTipoEmettitore",
                query = "SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :startDate AND :endDate AND TYPE(b.emettitore) = :tipoEmettitore"
        ),
        @NamedQuery(
                name = "Abbonamento.numeroTotaleByTipoEmettitore",
                query = "SELECT COUNT(a) FROM Abbonamento a WHERE a.dataEmissione BETWEEN :startDate AND :endDate AND a.emettitore = :tipoEmettitore"
        )


})
public abstract class DocumentoViaggio {

    @Id
    @GeneratedValue
    @Column(name = "documento_id")
    private long id;

    @Column(name = "data_emissione")
    private LocalDate dataEmissione;

    @ManyToOne
    @JoinColumn(name = "emettitore_id")
    private Emettitore emettitore;

    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @Column(name = "annullato")
    private boolean annullato;

    public DocumentoViaggio(){
        this.annullato = false;
    }
    public boolean isAnnullato() {
        return annullato;
    }

    public void setAnnullato(boolean annullato) {
        this.annullato = annullato;
    }
    @Column(name = "data_vidimazione")
    private LocalDate dataVidimazione;


    public LocalDate getDataVidimazione() {
        return dataVidimazione;
    }

    public void setDataVidimazione(LocalDate dataVidimazione) {
        this.dataVidimazione = dataVidimazione;
    }

    public DocumentoViaggio(LocalDate dataEmissione, double prezzo, Emettitore emettitore, Utente utente) {
        this.dataEmissione = dataEmissione;
        this.prezzo = prezzo;
        this.utente = utente;
        this.emettitore = emettitore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(LocalDate dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Emettitore getEmettitore() {
        return emettitore;
    }

    public void setEmettitore(Emettitore emettitore) {
        this.emettitore = emettitore;
    }

    @Override
    public String toString() {
        return "DocumentoViaggio{" +
                "id=" + id +
                ", dataEmissione=" + dataEmissione +
                ", emettitore=" + emettitore +
                ", prezzo=" + prezzo +
                ", utente=" + utente +
                '}';
    }
}
