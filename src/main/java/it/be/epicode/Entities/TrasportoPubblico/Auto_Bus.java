package it.be.epicode.Entities.TrasportoPubblico;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Random;

@Entity
@DiscriminatorValue("auto-bus")
public class Auto_Bus extends Mezzo {
    private String nomeVeicolo;

    private String tipologiaTrasporto = TipologiaTrasporto.AUTO_BUS.toString();
    private String targa = "";

    private int capienzaEffettiva = 40;

    private int capienzaAttuale;

    public Auto_Bus() {}

    public Auto_Bus(String partenza, String capolinea, long tempoMedioPercorso, boolean inServizio, Date dataInizioManutenzione, Date dataFineManutenzione, Date dataInizioServizio, Date dataFineServizio, String nomeVeicolo, String targa, int capienzaAttuale) {
        super(partenza, capolinea, tempoMedioPercorso, inServizio, dataInizioManutenzione, dataFineManutenzione, dataInizioServizio, dataFineServizio);
       nomeVeicolo = this.nomeVeicolo;
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
        int max = 40;
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
public void generazioneTarga(Auto_Bus auto_bus){
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
           auto_bus.targa = targa;
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

//Auto_Bus autoBus1 = new Auto_Bus("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"714","", randomCapienzaAttuale);
//        autoBus1.setInServizioInManutenzione(MESI.GENNAIO,2024);
//        autoBus1.setPercorsoTempoMedio(TERMINI_PALASPORT.TERMINI,TERMINI_PALASPORT.EUR_PALASPORT);
//        autoBus1.generazioneTarga(autoBus1);
//
//Auto_Bus autoBus2 = new Auto_Bus("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"16","", randomCapienzaAttuale);
//        autoBus2.setInServizioInManutenzione(MESI.FEBBRAIO,2024);
//        autoBus2.setPercorsoTempoMedio(TERMINI_PALASPORT.TERMINI,TERMINI_PALASPORT.NAVIGATORI);
//        autoBus2.generazioneTarga(autoBus2);
//
//Auto_Bus autoBus3 = new Auto_Bus("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"10","", randomCapienzaAttuale);
//        autoBus3.setInServizioInManutenzione(MESI.DICEMBRE,2024);
//        autoBus3.setPercorsoTempoMedio(TERMINI_PALASPORT.LAURENTINA,TERMINI_PALASPORT.TERME_CARACALLA);
//        autoBus3.generazioneTarga(autoBus3);

// ******************** SUPPLIERS ************************
//
//        int min = 1;
//        int max = 40;
//        Random random = new Random();
//        int randomCapienzaAttuale = random.nextInt(max - min) + min;


