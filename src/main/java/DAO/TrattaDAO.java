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

//    public void save1(Auto_Bus auto_bus) {
//        try{
//            if (auto_bus.getNomeVeicolo() == auto_bus.getNomeVeicolo()) {
//                System.out.println( auto_bus + "Esiste gia' nella raccolta");
//            } else {
//                EntityTransaction transaction = em.getTransaction();
//                transaction.begin();
//                em.merge(auto_bus);
//                transaction.commit();
//                System.out.println(auto_bus + "salvato correttamente");
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }

}
