package DAO;

import it.be.epicode.Entities.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class TesseraDAO {

    private EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tessera tessera) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(tessera);
            t.commit();
            System.out.println("Tessera - " + tessera.getId() + " - creata!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(Tessera tessera) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.remove(tessera);
            t.commit();
            System.out.println("Tessera - " + tessera.getId() + " - rimossa!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void isTesseraValid(Tessera tessera){
        if (tessera != null) {
            LocalDate dataAttuale = LocalDate.now();
            if (dataAttuale.isBefore(tessera.getDataScadenza())) {
                System.out.println("La tessera è valida.");
            } else {
                System.out.println("La tessera non è valida.");;
            }
        } else {
            System.out.println("Tessera non trovata.");;
        }
    }


}
