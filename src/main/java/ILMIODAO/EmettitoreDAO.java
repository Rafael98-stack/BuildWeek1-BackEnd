package ILMIODAO;

import it.be.epicode.Entities.TrasportoPubblico.Emettitore;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmettitoreDAO {

    private EntityManager em;

    public EmettitoreDAO(EntityManager em){
        this.em = em;
    }

    public void save(Emettitore emettitore) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(emettitore);
            t.commit();
            System.out.println("Emettitore - " + emettitore.getId() + " - creato! ✅");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(Emettitore emettitore) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.remove(emettitore);
            t.commit();
            System.out.println("Emettitore - " + emettitore.getClass() + " - eliminato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
