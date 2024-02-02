package it.be.epicode;

import DAO.TrattaDAO;
import com.github.javafaker.Faker;
import it.be.epicode.Entities.TrasportoPubblico.Auto_Bus;
import it.be.epicode.Entities.TrasportoPubblico.MESI;
import it.be.epicode.Entities.TrasportoPubblico.SANPAOLO_CASTEL_FUSANO;
import it.be.epicode.Entities.TrasportoPubblico.TERMINI_PALASPORT;
import it.be.epicode.Entities.TrasportoPubblico.Tram;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class App {

  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

  private static LocalDate randomLocalDate(Faker faker) {
    Date randomDate = faker.date().birthday();
    return randomDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }
    public static void main(String[]args){

      EntityManager em = emf.createEntityManager();
      Faker faker = new Faker(Locale.ITALY);

      LocalDate dataDiNascitaRandom = randomLocalDate(faker);


TrattaDAO trattaDAO = new TrattaDAO(em);


        // ******************** SUPPLIERS ************************

//        int min = 1;
//        int max = 40;
//        Random random = new Random();
//        int randomCapienzaAttualeAutobus = random.nextInt(max - min) + min;

//        int min1 = 1;
//        int max1 = 60;
//        Random random1 = new Random();
//        int randomCapienzaAttualeTram = random.nextInt(max - min) + min;

        // ******************** SALVATAGGIO TRATTA ************************



      Auto_Bus autoBus1 = new Auto_Bus("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"","", 0);
        autoBus1.setInServizioInManutenzione(MESI.GENNAIO,2024);
        autoBus1.setPercorsoTempoMedioAutoBus(TERMINI_PALASPORT.TERMINI,TERMINI_PALASPORT.EUR_PALASPORT);
        autoBus1.generazioneTarga(autoBus1);

        Auto_Bus autoBus2 = new Auto_Bus("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"","", 0);
        autoBus2.setInServizioInManutenzione(MESI.FEBBRAIO,2024);
        autoBus2.setPercorsoTempoMedioAutoBus(TERMINI_PALASPORT.TERMINI,TERMINI_PALASPORT.NAVIGATORI);
        autoBus2.generazioneTarga(autoBus2);

        Auto_Bus autoBus3 = new Auto_Bus("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"","", 0);
        autoBus3.setInServizioInManutenzione(MESI.DICEMBRE,2024);
        autoBus3.setPercorsoTempoMedioAutoBus(TERMINI_PALASPORT.LAURENTINA,TERMINI_PALASPORT.TERME_CARACALLA);
        autoBus3.generazioneTarga(autoBus3);

        Tram tram1 = new Tram("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"","", 0);
        tram1.setInServizioInManutenzione(MESI.LUGLIO,2024);
        tram1.setPercorsoTempoMedioTram(SANPAOLO_CASTEL_FUSANO.SAN_PAOLO,SANPAOLO_CASTEL_FUSANO.CASTEL_FUSANO);
        tram1.generazioneTarga(tram1);

        Tram tram2 = new Tram("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"","", 0);
        tram2.setInServizioInManutenzione(MESI.APRILE,2025);
        tram2.setPercorsoTempoMedioTram(SANPAOLO_CASTEL_FUSANO.CASTEL_FUSANO,SANPAOLO_CASTEL_FUSANO.SAN_PAOLO);
        tram2.generazioneTarga(tram2);

        Tram tram3 = new Tram("","",0,true,new Date(0),new Date(0),new Date(0),new Date(0),"","", 0);
        tram3.setInServizioInManutenzione(MESI.MARZO,2026);
        tram3.setPercorsoTempoMedioTram(SANPAOLO_CASTEL_FUSANO.CASAL_BERNOCCHI,SANPAOLO_CASTEL_FUSANO.EUR_MAGLIANA);
        tram3.generazioneTarga(tram3);

        System.out.println(tram3.getTarga());
        System.out.println(tram3.getCapienzaAttuale());
        System.out.println(tram3.getDataInizioManutenzione());
        System.out.println(tram3.getDataFineManutenzione());
        System.out.println(tram3.getDataInizioServizio());
        System.out.println(tram3.getDataFineServizio());

        trattaDAO.save(autoBus1);
//        trattaDAO.save(autoBus2);
//        trattaDAO.save(autoBus3);
//
//      trattaDAO.save(tram1);
//        trattaDAO.save(tram2);
//        trattaDAO.save(tram3);

    


      em.close();
      emf.close();
    }
  }

