package it.be.epicode.Entities.Biglietteria.TrasportoPubblico;

import javax.persistence.*;

@Entity
@Table(name="tratta")
@DiscriminatorColumn(name = "tratta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Tratta {
@Id
    @GeneratedValue
private Long Id;
    private String partenza;
private String capolinea;

private long tempoMedioPercorso;

    public Tratta() {
    }

    public Tratta(String partenza, String capolinea, long tempoMedioPercorso) {
        this.partenza = partenza;
        this.capolinea = capolinea;
        this.tempoMedioPercorso = tempoMedioPercorso;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPartenza() {
        return partenza;
    }

    public void setPartenza(String partenza) {
        this.partenza = partenza;
    }

    public String getCapolinea() {
        return capolinea;
    }

    public void setCapolinea(String capolinea) {
        this.capolinea = capolinea;
    }

    public long getTempoMedioPercorso() {
        return tempoMedioPercorso;
    }

    public void setTempoMedioPercorso(long tempoMedioPercorso) {
        this.tempoMedioPercorso = tempoMedioPercorso;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "Id=" + Id +
                ", partenza='" + partenza + '\'' +
                ", capolinea='" + capolinea + '\'' +
                ", tempoMedioPercorso=" + tempoMedioPercorso +
                '}';
    }
}
