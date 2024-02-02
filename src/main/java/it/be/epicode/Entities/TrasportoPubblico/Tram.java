package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Random;

@Entity
@DiscriminatorValue("tram")
public class Tram extends Mezzo {
    private String nomeVeicolo;
    private String tipologiaTrasporto = TipologiaTrasporto.TRAM.toString();
    private String targa = "";
    private int capienzaEffettiva = 60;
    private int capienzaAttuale;
    public Tram() {}

    public Tram(String partenza, String capolinea, long tempoMedioPercorso, boolean inServizio, Date dataInizioManutenzione, Date dataFineManutenzione, Date dataInizioServizio, Date dataFineServizio, String nomeVeicolo, String targa, int capienzaAttuale) {
        super(partenza, capolinea, tempoMedioPercorso, inServizio, dataInizioManutenzione, dataFineManutenzione, dataInizioServizio, dataFineServizio);
        this.nomeVeicolo = nomeVeicolo;
        targa = this.targa;
        this.capienzaAttuale = capienzaAttuale;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getNomeVeicolo() {
        return nomeVeicolo;
    }

    public void setNomeVeicolo(String nomeVeicolo) {
        this.nomeVeicolo = nomeVeicolo;
    }

    public String  getTipologiaTrasporto() {
        return tipologiaTrasporto;
    }

    public void setTipologiaTrasporto(String tipologiaTrasporto) {
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

    public ALFABETO getRandomAlfabeto() {
        return ALFABETO.values()[new Random().nextInt(ALFABETO.values().length)];
    }
    public int getRandomInt () {
        int min = 10;
        int max = 60;
        Random random = new Random();
        int randomCapienzaAttualeAutobus = random.nextInt(max - min) + min;
        return randomCapienzaAttualeAutobus;
    }
    public String getRandomNome () {
        int min = 1;
        int max = 100;
        Random random = new Random();
        int randomInt = random.nextInt(max - min) + min;

        String nome = getRandomAlfabeto().toString() + randomInt;
        return nome;
    }
    public void generazioneTarga(Tram tram){
        this.nomeVeicolo = getRandomNome();
this.capienzaAttuale = getRandomInt();
        int min = 100;
        int max = 999;
        Random random = new Random();
        int intTarga = random.nextInt(max - min) + min;

//    String iniziale = ALFABETO.A.toString();
//        String finale = ALFABETO.A.toString();
        String targa = "";
        switch (targa) {
            case "" :
                targa = getRandomAlfabeto().toString() + intTarga + getRandomAlfabeto().toString();
                tram.targa = targa;
                break;
//       case :
//           break;
        }


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
