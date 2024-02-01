package it.be.epicode;

import DAO.*;
import com.github.javafaker.Faker;
import it.be.epicode.Entities.*;
import it.be.epicode.Entities.TrasportoPubblico.Auto_Bus;
import it.be.epicode.Entities.TrasportoPubblico.MESI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

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
      TipoAbbonamento[] tipoAbbonamento = TipoAbbonamento.values();
      TipoAbbonamento tipoAbbonamentoRandom = tipoAbbonamento[new Random().nextInt(tipoAbbonamento.length)];

TrattaDAO trattaDAO = new TrattaDAO(em);
      UtenteDAO utenteDAO = new UtenteDAO(em);
      EmettitoreDAO emettitoreDAO = new EmettitoreDAO(em);
      DocumentoViaggioDAO documentoViaggioDAO = new DocumentoViaggioDAO(em);
      TesseraDAO tesseraDAO = new TesseraDAO(em);

        // ******************** SUPPLIERS ************************

//        Supplier<Integer> integerSupplier = () -> {
//            Random rndm = new Random();
//            int i = rndm.nextInt(1, 101);
//            return i;
//        };

      // ******************** SALVATAGGIO TRATTA ************************



      Auto_Bus autoBus1 = new Auto_Bus("Termini","Eur_PalaSport",45,true,new Date(2000),new Date(2000),new Date(2000),new Date(2000),"714","AA555AA",40);
      System.out.println(autoBus1);

      autoBus1.setInServizioInManutenzione(MESI.FEBBRAIO,2024);
        System.out.println(autoBus1.getDataFineServizio());
      trattaDAO.save(autoBus1);

      // ******************** SALVATAGGIO UTENTI ************************

      Utente utente1 = new Utente(faker.name().firstName(), faker.name().lastName(), dataDiNascitaRandom);
//      utenteDAO.save(utente1);

      // ******************** SALVATAGGIO DISTRIBUTORI & RIVENDITORI ************************

      Distributore distributore1 = new Distributore(true);
      Distributore distributore2 = new Distributore(false);
//      emettitoreDAO.save(distributore1);
//      emettitoreDAO.save(distributore2);

      Rivenditore rivenditore1 = new Rivenditore();
//      emettitoreDAO.save(rivenditore1);

      // ******************** SALVATAGGIO BIGLIETTI ************************

      Biglietto biglietto1 = new Biglietto(LocalDate.of(2023, 01, 12), 2.5, distributore1, utente1);
//      documentoViaggioDAO.save(biglietto1);
      Biglietto biglietto2 = new Biglietto(LocalDate.of(2023, 12, 12), 2.5, rivenditore1, utente1);
//      documentoViaggioDAO.save(biglietto2);
      Biglietto biglietto3 = new Biglietto(LocalDate.of(2024, 01, 05), 2.5, distributore1, utente1);
//      documentoViaggioDAO.save(biglietto3);

      // ******************** SALVATAGGIO TESSERE & ABBONAMENTI ************************

      Tessera tessera1 = new Tessera(LocalDate.of(2023, 12, 25), utente1);
      Tessera tessera2 = new Tessera(LocalDate.of(2023, 01, 11), utente1);
//      tesseraDAO.save(tessera1);
      tesseraDAO.isTesseraValid(tessera1);
//      tesseraDAO.save(tessera2);
      tesseraDAO.isTesseraValid(tessera2);

      Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2023,12,30),39.50, rivenditore1, utente1, tessera1, tipoAbbonamentoRandom);
//      documentoViaggioDAO.save(abbonamento1);
      Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2023,12,22),25.90, distributore1, utente1, tessera1, tipoAbbonamentoRandom);
//      documentoViaggioDAO.save(abbonamento2);
      Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2023,11,13),39.50, rivenditore1, utente1, tessera2, tipoAbbonamentoRandom);
//      documentoViaggioDAO.save(abbonamento3);
      Abbonamento abbonamento4 = new Abbonamento(LocalDate.of(2023,10,11),39.50, rivenditore1, utente1, tessera2, tipoAbbonamentoRandom);
//      documentoViaggioDAO.save(abbonamento4);




      // ******************** METODI RICERCA ************************

      System.out.println("***NUMERO TOTALE BIGLIETTI EMESSI***");
      System.out.println(documentoViaggioDAO.numeroTotaleBiglietti(LocalDate.of(2023, 05, 30), LocalDate.of(2024, 01, 26)));
      System.out.println("***NUMERO TOTALE ABBONAMENTI EMESSI***");
      System.out.println(documentoViaggioDAO.numeroTotaleAbbonamenti(LocalDate.of(2023, 05, 30), LocalDate.of(2024, 01, 26)));
      System.out.println("_______________________");
      System.out.println("***NUMERO BIGLIETTI EMESSI PER PUNTO DI EMISSIONE***");
      System.out.println("Da distributori automatici: " + documentoViaggioDAO.numeroTotaleBigliettiByDistributore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), distributore1));
      System.out.println("Da rivenditori autorizzati: " + documentoViaggioDAO.numeroTotaleBigliettiByRivenditore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), rivenditore1));
      System.out.println("_______________________");
      System.out.println("***NUMERO ABBONAMENTI EMESSI PER PUNTO DI EMISSIONE***");
      System.out.println("Da distributori automatici: " + documentoViaggioDAO.numeroTotaleAbbonamentiByDistributore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), distributore1));
      System.out.println("Da rivenditori autorizzati: " + documentoViaggioDAO.numeroTotaleAbbonamentiByRivenditore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), rivenditore1));




      em.close();
      emf.close();
    }
  }

