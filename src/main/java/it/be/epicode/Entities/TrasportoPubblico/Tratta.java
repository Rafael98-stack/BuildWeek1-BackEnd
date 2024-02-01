package it.be.epicode.Entities.TrasportoPubblico;

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
        partenza = this.partenza;
       capolinea = this.capolinea;
        tempoMedioPercorso = this.tempoMedioPercorso;
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

    public void setPercorsoTempoMedio(TERMINI_PALASPORT partenza,TERMINI_PALASPORT capolinea){
String inizio1 = "TERMINI";
        String inizio2 = "TERME_CARACALLA";
        String inizio3 = "NAVIGATORI";
        String inizio4 = "LAURENTINA";
        String inizio5 = "EUR_PALASPORT";

        String fine1 = "TERMINI";
        String fine2 = "TERME_CARACALLA";
        String fine3 = "NAVIGATORI";
        String fine4 = "LAURENTINA";
        String fine5 = "EUR_PALASPORT";

        int posizioneAttuale = 0;
        int posizioneSuccessiva = 10;


    switch (partenza){
        case TERMINI:
            switch (capolinea){
                case TERMINI:
                    this.capolinea = fine1;
                    this.tempoMedioPercorso = posizioneAttuale;
                    break;
                case TERME_CARACALLA:
                    this.capolinea = fine2;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case NAVIGATORI:
                    this.capolinea = fine3;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 2;
                    break;
                case LAURENTINA:
                    this.capolinea = fine4;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 3;
                    break;
                case EUR_PALASPORT:
                    this.capolinea = fine5;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 4;
                    break;
            }
            this.partenza=inizio1;
            break;
        case TERME_CARACALLA:
            switch (capolinea){
                case TERMINI:
                    this.capolinea = fine1;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case TERME_CARACALLA:
                    this.capolinea = fine2;
                    this.tempoMedioPercorso = posizioneAttuale;
                    break;
                case NAVIGATORI:
                    this.capolinea = fine3;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case LAURENTINA:
                    this.capolinea = fine4;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 2;
                    break;
                case EUR_PALASPORT:
                    this.capolinea = fine5;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 3;
                    break;
            }
            this.partenza=inizio2;
            break;
        case NAVIGATORI:
            switch (capolinea){
                case TERMINI:
                    this.capolinea = fine1;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 2;
                    break;
                case TERME_CARACALLA:
                    this.capolinea = fine2;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case NAVIGATORI:
                    this.capolinea = fine3;
                    this.tempoMedioPercorso = posizioneAttuale;
                    break;
                case LAURENTINA:
                    this.capolinea = fine4;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case EUR_PALASPORT:
                    this.capolinea = fine5;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 2;
                    break;
            }
            this.partenza=inizio3;
            break;
        case LAURENTINA:
            switch (capolinea){
                case TERMINI:
                    this.capolinea = fine1;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 3;
                    break;
                case TERME_CARACALLA:
                    this.capolinea = fine2;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 2;
                    break;
                case NAVIGATORI:
                    this.capolinea = fine3;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case LAURENTINA:
                    this.capolinea = fine4;
                    this.tempoMedioPercorso = posizioneAttuale;
                    break;
                case EUR_PALASPORT:
                    this.capolinea = fine5;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
            }
            this.partenza=inizio4;
            break;
        case EUR_PALASPORT:
            switch (capolinea){
                case TERMINI:
                    this.capolinea = fine1;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 4;
                    break;
                case TERME_CARACALLA:
                    this.capolinea = fine2;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 3;
                    break;
                case NAVIGATORI:
                    this.capolinea = fine3;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva * 2;
                    break;
                case LAURENTINA:
                    this.capolinea = fine4;
                    this.tempoMedioPercorso = posizioneAttuale + posizioneSuccessiva;
                    break;
                case EUR_PALASPORT:
                    this.capolinea = fine5;
                    this.tempoMedioPercorso = posizioneAttuale;
                    break;
            }
            this.partenza=inizio5;
            break;
    }
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
