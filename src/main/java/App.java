

import com.github.javafaker.Faker;
import it.be.epicode.Entities.TipoAbbonamento;

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

//    Auto_Bus autoBus1 = new Auto_Bus(true, LocalDate.of(2024,2,10),LocalDate.of(2024,3,10),LocalDate.of(2024,3,11),LocalDate.of(2025,2,9));
//    System.out.println(autoBus1);
//
//    Tram tram1 = new Tram("C110");
//    System.out.println(tram1);

      EntityManager em = emf.createEntityManager();
      Faker faker = new Faker(Locale.ITALY);
      LocalDate dataDiNascitaRandom = randomLocalDate(faker);
      TipoAbbonamento[] tipoAbbonamento = TipoAbbonamento.values();
      TipoAbbonamento tipoAbbonamentoRandom = tipoAbbonamento[new Random().nextInt(tipoAbbonamento.length)];

      it.epicode.be.dao.UtenteDAO utenteDAO = new it.epicode.be.dao.UtenteDAO(em);
      it.epicode.be.dao.EmettitoreDAO emettitoreDAO = new it.epicode.be.dao.EmettitoreDAO(em);
      it.epicode.be.dao.DocumentoViaggioDAO documentoViaggioDAO = new it.epicode.be.dao.DocumentoViaggioDAO(em);
      it.epicode.be.dao.TesseraDAO tesseraDAO = new it.epicode.be.dao.TesseraDAO(em);

      // ******************** SALVATAGGIO UTENTI ************************

      it.epicode.be.entities.Utente utente1 = new it.epicode.be.entities.Utente(faker.name().firstName(), faker.name().lastName(), dataDiNascitaRandom);
      utenteDAO.save(utente1);

      // ******************** SALVATAGGIO DISTRIBUTORI & RIVENDITORI ************************

      it.epicode.be.entities.Distributore distributore1 = new it.epicode.be.entities.Distributore(true);
      it.epicode.be.entities.Distributore distributore2 = new it.epicode.be.entities.Distributore(false);
      emettitoreDAO.save(distributore1);
      emettitoreDAO.save(distributore2);

      it.epicode.be.entities.Rivenditore rivenditore1 = new it.epicode.be.entities.Rivenditore();
      emettitoreDAO.save(rivenditore1);

      // ******************** SALVATAGGIO BIGLIETTI ************************

      it.epicode.be.entities.Biglietto biglietto1 = new it.epicode.be.entities.Biglietto(LocalDate.of(2023, 01, 12), 2.5, distributore1, utente1);
      documentoViaggioDAO.save(biglietto1);
      it.epicode.be.entities.Biglietto biglietto2 = new it.epicode.be.entities.Biglietto(LocalDate.of(2023, 12, 12), 2.5, rivenditore1, utente1);
      documentoViaggioDAO.save(biglietto2);
      it.epicode.be.entities.Biglietto biglietto3 = new it.epicode.be.entities.Biglietto(LocalDate.of(2024, 01, 05), 2.5, distributore1, utente1);
      documentoViaggioDAO.save(biglietto3);

      // ******************** SALVATAGGIO TESSERE & ABBONAMENTI ************************

      it.epicode.be.entities.Tessera tessera1 = new it.epicode.be.entities.Tessera(LocalDate.of(2023, 12, 25), utente1);
      it.epicode.be.entities.Tessera tessera2 = new it.epicode.be.entities.Tessera(LocalDate.of(2023, 01, 11), utente1);
      tesseraDAO.save(tessera1);
      tesseraDAO.isTesseraValid(tessera1);
      tesseraDAO.save(tessera2);
      tesseraDAO.isTesseraValid(tessera2);

      it.epicode.be.entities.Abbonamento abbonamento1 = new it.epicode.be.entities.Abbonamento(LocalDate.of(2023, 12, 30), 39.50, rivenditore1, utente1, tessera1, tipoAbbonamentoRandom);
      documentoViaggioDAO.save(abbonamento1);
      it.epicode.be.entities.Abbonamento abbonamento2 = new it.epicode.be.entities.Abbonamento(LocalDate.of(2023, 12, 22), 25.90, distributore1, utente1, tessera1, tipoAbbonamentoRandom);
      documentoViaggioDAO.save(abbonamento2);
      it.epicode.be.entities.Abbonamento abbonamento3 = new it.epicode.be.entities.Abbonamento(LocalDate.of(2023, 11, 13), 39.50, rivenditore1, utente1, tessera2, tipoAbbonamentoRandom);
      documentoViaggioDAO.save(abbonamento3);
      it.epicode.be.entities.Abbonamento abbonamento4 = new it.epicode.be.entities.Abbonamento(LocalDate.of(2023, 10, 11), 39.50, rivenditore1, utente1, tessera2, tipoAbbonamentoRandom);
      documentoViaggioDAO.save(abbonamento4);


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

