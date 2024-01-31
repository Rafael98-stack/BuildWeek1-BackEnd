package it.be.epicode.Entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "abbonamenti")
public class Abbonamento extends DocumentoViaggio {


    @OneToOne
    @JoinColumn(name = "tessera_id")
    private Tessera tessera;

    @Column(name = "tipo_abbonamento")
    @Enumerated(EnumType.STRING)
    private TipoAbbonamento tipoAbbonamento;


    public Abbonamento() {
    }

    public Abbonamento(LocalDate dataEmissione, double prezzo, Emettitore emettitore, Utente utente, Tessera tessera, TipoAbbonamento tipoAbbonamento) {
        super(dataEmissione, prezzo, emettitore, utente);
        this.tessera = tessera;
        this.tipoAbbonamento = tipoAbbonamento;

    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public TipoAbbonamento getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(TipoAbbonamento tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "tessera=" + tessera +
                ", tipoAbbonamento=" + tipoAbbonamento +
                "} " + super.toString();
    }
}
