package DAO;

import it.be.epicode.Entities.TrasportoPubblico.Tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TrattaDAO {
    private EntityManager em;

    public TrattaDAO(EntityManager em){this.em = em;}

    public void save(Tratta tratta) {
        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.merge(tratta);
            transaction.commit();
            System.out.println( tratta + "salvato correttamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
