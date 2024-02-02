package ILMIODAO;

import it.be.epicode.Entities.TrasportoPubblico.Tessera;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
            System.out.println("Tessera - " + tessera.getId() + " - creata! ✅");
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




}
