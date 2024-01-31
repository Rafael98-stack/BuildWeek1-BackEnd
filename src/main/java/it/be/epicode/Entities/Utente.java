package it.be.epicode.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utente {


    @Id
    @GeneratedValue
    @Column(name = "utente_id")
    private long id;

    private String nome;
    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @OneToOne(mappedBy = "utente")
    private Tessera tessera;

    @OneToMany(mappedBy = "utente")
    private List<Biglietto> biglietti = new ArrayList<>();

    @OneToMany(mappedBy = "utente")
    private List<Abbonamento> abbonamenti = new ArrayList<>();

    public Utente(){}

    public Utente(String nome, String cognome, LocalDate dataDiNascita){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }

    public List<Biglietto> getBiglietti() {
        return biglietti;
    }

    public void setBiglietti(List<Biglietto> biglietti) {
        this.biglietti = biglietti;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public void setAbbonamenti(List<Abbonamento> abbonamenti) {
        this.abbonamenti = abbonamenti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", tessera=" + tessera +
                ", biglietti=" + biglietti +
                ", abbonamenti=" + abbonamenti +
                '}';
    }
}