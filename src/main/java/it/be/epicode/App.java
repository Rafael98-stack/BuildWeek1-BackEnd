package it.be.epicode;

import DAO.DocumentoViaggioDAO;
import DAO.EmettitoreDAO;
import DAO.TesseraDAO;
import DAO.UtenteDAO;
import com.github.javafaker.Faker;
import it.be.epicode.Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class App {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trasporto_Pubblico");

    private static LocalDate randomLocalDate(Faker faker) {
        Date randomDate = faker.date().birthday();
        return randomDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        LocalDate dataRandom = randomLocalDate(faker);
        TipoAbbonamento[] tipoAbbonamento = TipoAbbonamento.values();
        UtenteDAO utenteDAO = new UtenteDAO(em);
        EmettitoreDAO emettitoreDAO = new EmettitoreDAO(em);
        DocumentoViaggioDAO documentoViaggioDAO = new DocumentoViaggioDAO(em);
        TesseraDAO tesseraDAO = new TesseraDAO(em);


        Scanner scanner = new Scanner(System.in);

        List<Utente> utentiCreati = new ArrayList<>();
        System.out.println("➡️CREAZIONE UTENTI⬅️");
        System.out.println("🔘Inserisci il numero di utenti da creare");
        int numeroUtenti = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numeroUtenti; i++) {
            Utente utente = new Utente(faker.name().firstName(), faker.name().lastName(), dataRandom);
            utenteDAO.save(utente);
            utentiCreati.add(utente);
        }
        scanner.nextLine();

        System.out.println();
        List<Emettitore> emettitoriCreati = new ArrayList<>();
        System.out.println("➡️CREAZIONE DISTRIBUTORE AUTOMATICO⬅️");
        System.out.println("🔘Il distributore è in funzione? (1 se è in funzione, 2 se non è in funzione)");
        int sceltaInFunzione = scanner.nextInt();
        if (sceltaInFunzione == 1) {
            Distributore distributore = new Distributore(true);
            emettitoreDAO.save(distributore);
            emettitoriCreati.add(distributore);
        } else if (sceltaInFunzione == 2) {
            Distributore distributore = new Distributore(false);
            emettitoreDAO.save(distributore);
            emettitoriCreati.add(distributore);
        }
        scanner.nextLine();
        System.out.println();
        System.out.println("➡️CREAZIONE RIVENDITORE AUTORIZZATO⬅️");
        System.out.println("⏎ Premi Invio per creare un rivenditore autorizzato");
        scanner.nextLine();
        Rivenditore rivenditore = new Rivenditore();
        emettitoreDAO.save(rivenditore);
        emettitoriCreati.add(rivenditore);
        scanner.nextLine();
        System.out.println();

        System.out.println("➡️EMISSIONE BIGLIETTI⬅️");
        Emettitore emettitoreAssociato = null;
        while(emettitoreAssociato == null) {
            System.out.println("🔘Seleziona l'id del distributore o rivenditore che deve emettere i biglietti");

            int idEmettitoreDesiderato = scanner.nextInt();
            scanner.nextLine();
            emettitoreAssociato = emettitoriCreati.stream()
                    .filter(emettitore -> emettitore.getId() == idEmettitoreDesiderato)
                    .findFirst()
                    .orElse(null);
            if (emettitoreAssociato == null) {
                System.out.println("❌❌❌ Errore: ID emettitore non valido. Inserisci un ID valido. ❌❌❌");
            }
        }
        System.out.println("🔘Inserisci il numero di biglietti da emettere");
        int numeroBiglietti = scanner.nextInt();
        scanner.nextLine();
        if (numeroBiglietti > 0) {
            Utente utenteAssociato = null;
            while (utenteAssociato == null) {
                System.out.println("🔘Seleziona l'id dell'utente a cui vendere i biglietti");
                int idUtenteDesiderato = scanner.nextInt();
                scanner.nextLine();
                utenteAssociato = utentiCreati.stream()
                        .filter(utente -> utente.getId() == idUtenteDesiderato)
                        .findFirst()
                        .orElse(null);
                if (utenteAssociato == null) {
                    System.out.println("❌❌❌ Errore: ID utente non valido. Inserisci un ID utente valido. ❌❌❌");
                }
            }
            for (int i = 0; i < numeroBiglietti; i++) {

                if (sceltaInFunzione == 1 && emettitoreAssociato instanceof Distributore || emettitoreAssociato instanceof Rivenditore) {
                    Biglietto biglietto = new Biglietto(
                            LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1),
                            2.5,
                            emettitoreAssociato,
                            utenteAssociato
                    );
                    documentoViaggioDAO.save(biglietto);
                } else if (sceltaInFunzione == 2 && emettitoreAssociato instanceof Distributore) {
                    System.out.println("️❌❌❌ Errore: Il distributore non è in funzione. Impossibile emettere il biglietto. ❌❌❌");
                }
            }
        } else {
            System.out.println("Nessun biglietto emesso.");
        }
        scanner.nextLine();
        System.out.println("➡️CREAZIONE TESSERA⬅️");
        Utente possessoreTessera = null;
        while(possessoreTessera == null) {
            System.out.println("🔘Seleziona l'id dell'utente a cui associare la tessera");
            int idPossessoreTessera = scanner.nextInt();
            possessoreTessera = utentiCreati.stream()
                    .filter(utente -> utente.getId() == idPossessoreTessera)
                    .findFirst()
                    .orElse(null);
            if (possessoreTessera == null) {
                System.out.println("❌❌❌ Errore: ID utente non valido. Inserisci un ID utente valido. ❌❌❌");
            }
        }
        Tessera tessera = new Tessera(LocalDate.of(2023, 12, new Random().nextInt(28) + 1), possessoreTessera);
        tesseraDAO.save(tessera);
        System.out.println("Tessera associata a " + possessoreTessera.getNome() + " " + possessoreTessera.getCognome() + "! ✅");
        scanner.nextLine();
        System.out.println();
        System.out.println("➡️EMISSIONE ABBONAMENTI⬅️");
        Emettitore emettitoreAssociato2 = null;
        while(emettitoreAssociato2 == null) {
            System.out.println("🔘Seleziona l'id del distributore o rivenditore che deve emettere gli abbonamenti");
            int idEmettitoreDesiderato2 = scanner.nextInt();
            scanner.nextLine();
            emettitoreAssociato2 = emettitoriCreati.stream()
                    .filter(emettitore -> emettitore.getId() == idEmettitoreDesiderato2)
                    .findFirst()
                    .orElse(null);
            if (emettitoreAssociato2 == null) {
                System.out.println("❌❌❌ Errore: ID emettitore non valido. Inserisci un ID valido. ❌❌❌");
            }
        }
        System.out.println("🔘Inserisci il numero di abbonamenti da emettere");
        int numeroAbbonamenti = scanner.nextInt();
        scanner.nextLine();
        if (numeroAbbonamenti > 0) {
            Utente utenteAssociato2 = null;
            while(utenteAssociato2 == null) {
                System.out.println("🔘Inserisci l'id dell'utente a cui vendere gli abbonamenti");
                int idUtenteDesiderato2 = scanner.nextInt();
                scanner.nextLine();
                utenteAssociato2 = utentiCreati.stream()
                        .filter(utente -> utente.getId() == idUtenteDesiderato2)
                        .findFirst()
                        .orElse(null);
                if (utenteAssociato2 == null) {
                    System.out.println("❌❌❌ Errore: ID utente non valido. Inserisci un ID utente valido. ❌❌❌");
                }
            }
            if(tessera.isTesseraValid(tessera)){
                System.out.println(utenteAssociato2.getNome() + " " + utenteAssociato2.getCognome() + " ha una tessera valida! ✅");
                for (int i = 0; i < numeroAbbonamenti; i++) {
                    if (sceltaInFunzione == 1 && emettitoreAssociato2 instanceof Distributore || emettitoreAssociato2 instanceof Rivenditore) {
                        double prezzo = 0.0;
                        TipoAbbonamento tipoAbbonamentoRandom = tipoAbbonamento[new Random().nextInt(tipoAbbonamento.length)];
                        if(tipoAbbonamentoRandom.equals(TipoAbbonamento.MENSILE)){
                            prezzo = 39.50;
                        } else if (tipoAbbonamentoRandom.equals(TipoAbbonamento.SETTIMANALE)){
                            prezzo = 15.90;
                        }
                        Abbonamento abbonamento = new Abbonamento(LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1), prezzo, emettitoreAssociato2, utenteAssociato2, tessera, tipoAbbonamentoRandom);
                        documentoViaggioDAO.save(abbonamento);
                    } else if (sceltaInFunzione == 2 && emettitoreAssociato2 instanceof Distributore) {
                        System.out.println("️❌❌❌ Errore: Il distributore non è in funzione. Impossibile emettere l'abbonamento. ❌❌❌");
                    }
                }
            } else {
                System.out.println("❌❌❌ Errore: La tessera associata non è valida. Impossibile emettere l'abbonamento. ❌❌❌");
            }
        } else {
            System.out.println("Nessun abbonamento emesso.");
        }


        scanner.close();


        // ******************** SALVATAGGIO UTENTI ************************

//        Utente utente1 = new Utente(faker.name().firstName(), faker.name().lastName(), dataRandom);
//        utenteDAO.save(utente1);

        // ******************** SALVATAGGIO DISTRIBUTORI & RIVENDITORI ************************

//        Distributore distributore1 = new Distributore(true);
//        Distributore distributore2 = new Distributore(false);
//        emettitoreDAO.save(distributore1);
//        emettitoreDAO.save(distributore2);
//
//        Rivenditore rivenditore1 = new Rivenditore();
//        emettitoreDAO.save(rivenditore1);

        // ******************** SALVATAGGIO BIGLIETTI ************************

//        if (distributore1.isInFunzione()){
//        Biglietto biglietto1 = new Biglietto(LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1), 2.5, distributore1, utente1);
//        documentoViaggioDAO.save(biglietto1);
//        } else {
//            System.out.println("‼️Errore: Il distributore non è in funzione. Impossibile emettere il biglietto.‼️");
//        }
//        Biglietto biglietto2 = new Biglietto(LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1), 2.5, rivenditore1, utente1);
//        documentoViaggioDAO.save(biglietto2);
//
//        if (distributore2.isInFunzione()) {
//            Biglietto biglietto3 = new Biglietto(LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1), 2.5, distributore2, utente1);
//            documentoViaggioDAO.save(biglietto3);
//        } else {
//            System.out.println("‼️Errore: Il distributore non è in funzione. Impossibile emettere il biglietto.‼️");
//        }

        // ******************** SALVATAGGIO TESSERE & ABBONAMENTI ************************

//        Tessera tessera1 = new Tessera(LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1), utente1);
//        Tessera tessera2 = new Tessera(LocalDate.of(2023, new Random().nextInt(12) + 1, new Random().nextInt(28) + 1), utente1);
//        tesseraDAO.save(tessera1);
//        tesseraDAO.isTesseraValid(tessera1);
//        tesseraDAO.save(tessera2);
//        tesseraDAO.isTesseraValid(tessera2);
//
//        Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2023,new Random().nextInt(12) + 1,new Random().nextInt(28) + 1),39.50, rivenditore1, utente1, tessera1, (new Random().nextInt(2) == 0) ? TipoAbbonamento.SETTIMANALE : TipoAbbonamento.MENSILE);
//        documentoViaggioDAO.save(abbonamento1);
//        Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2023,new Random().nextInt(12) + 1,new Random().nextInt(28) + 1),25.90, distributore1, utente1, tessera1, (new Random().nextInt(2) == 0) ? TipoAbbonamento.SETTIMANALE : TipoAbbonamento.MENSILE);
//        documentoViaggioDAO.save(abbonamento2);
//        Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2023,new Random().nextInt(12) + 1,new Random().nextInt(28) + 1),39.50, rivenditore1, utente1, tessera2, (new Random().nextInt(2) == 0) ? TipoAbbonamento.SETTIMANALE : TipoAbbonamento.MENSILE);
//        documentoViaggioDAO.save(abbonamento3);
//        Abbonamento abbonamento4 = new Abbonamento(LocalDate.of(2023,new Random().nextInt(12) + 1,new Random().nextInt(28) + 1),39.50, rivenditore1, utente1, tessera2, (new Random().nextInt(2) == 0) ? TipoAbbonamento.SETTIMANALE : TipoAbbonamento.MENSILE);
//        documentoViaggioDAO.save(abbonamento4);


        // ******************** METODI RICERCA ************************

        System.out.println("➡️NUMERO TOTALE BIGLIETTI EMESSI⬅️");
        System.out.println(documentoViaggioDAO.numeroTotaleBiglietti(LocalDate.of(2022, 05, 30), LocalDate.of(2024, 01, 26)));
        System.out.println("➡️NUMERO TOTALE ABBONAMENTI EMESSI⬅️");
        System.out.println(documentoViaggioDAO.numeroTotaleAbbonamenti(LocalDate.of(2022, 05, 30), LocalDate.of(2024, 01, 26)));
        System.out.println("➖➖➖➖➖➖➖➖➖➖");
//        System.out.println("➡️NUMERO BIGLIETTI EMESSI PER PUNTO DI EMISSIONE⬅️");
//        System.out.println("Da distributori automatici: " + documentoViaggioDAO.numeroTotaleBigliettiByDistributore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), ));
//        System.out.println("Da rivenditori autorizzati: " + documentoViaggioDAO.numeroTotaleBigliettiByRivenditore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), ));
//        System.out.println("➖➖➖➖➖➖➖➖➖➖");
//        System.out.println("➡️NUMERO ABBONAMENTI EMESSI PER PUNTO DI EMISSIONE⬅️");
//        System.out.println("Da distributori automatici: " + documentoViaggioDAO.numeroTotaleAbbonamentiByDistributore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), ));
//        System.out.println("Da rivenditori autorizzati: " + documentoViaggioDAO.numeroTotaleAbbonamentiByRivenditore(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), ));


//        System.out.println("➡️DOCUMENTI VIAGGIO EMESSI PER PUNTO DI EMISSIONE⬅️");
//          documentoViaggioDAO.trovaDocumentiPerPuntoDiEmissione(LocalDate.of(2022, 12, 30), LocalDate.of(2024, 02, 26), 654).forEach(System.out::println);


        em.close();
        emf.close();
    }


}

