package ILMIODAO;

import it.be.epicode.Entities.TrasportoPubblico.Distributore;
import it.be.epicode.Entities.TrasportoPubblico.Emettitore;
import it.be.epicode.Entities.TrasportoPubblico.Rivenditore;
import it.be.epicode.Entities.TrasportoPubblico.DocumentoViaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class DocumentoViaggioDAO {

    private EntityManager em;

    public DocumentoViaggioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(DocumentoViaggio doc) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();

            em.persist(doc);
            t.commit();
            System.out.println("Documento di viaggio - " + doc.getId() + " - creato! ✅");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(DocumentoViaggio doc) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.remove(doc);
            t.commit();
            System.out.println("Abbonamento - " + doc.getId() + " - rimosso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public long numeroTotaleBiglietti(LocalDate startDate, LocalDate endDate) {
        return (long) em.createNamedQuery("Biglietto.numeroTotale")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
    }

    public long numeroTotaleAbbonamenti(LocalDate startDate, LocalDate endDate) {
        return (long) em.createNamedQuery("Abbonamento.numeroTotale")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getSingleResult();
    }


    public long numeroTotaleBigliettiByDistributore(LocalDate startDate, LocalDate endDate, Emettitore tipoEmettitore) {
        return (long) em.createNamedQuery("Biglietto.numeroTotaleByTipoEmettitore")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("tipoEmettitore", tipoEmettitore)
                .getSingleResult();
    }
    public long numeroTotaleBigliettiByRivenditore(LocalDate startDate, LocalDate endDate, Rivenditore tipoEmettitore) {
        return (long) em.createNamedQuery("Biglietto.numeroTotaleByTipoEmettitore")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("tipoEmettitore", tipoEmettitore)
                .getSingleResult();
    }



    public long numeroTotaleAbbonamentiByRivenditore(LocalDate startDate, LocalDate endDate, Rivenditore tipoEmettitore) {
        return (long) em.createNamedQuery("Abbonamento.numeroTotaleByTipoEmettitore")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("tipoEmettitore", tipoEmettitore)
                .getSingleResult();
    }

    public long numeroTotaleAbbonamentiByDistributore(LocalDate startDate, LocalDate endDate, Distributore tipoEmettitore) {
        return (long) em.createNamedQuery("Abbonamento.numeroTotaleByTipoEmettitore")
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .setParameter("tipoEmettitore", tipoEmettitore)
                .getSingleResult();
    }

//    public List<DocumentoViaggio> trovaDocumentiPerPuntoDiEmissione(LocalDate startDate, LocalDate endDate, int idRivenditore) {
//        TypedQuery<DocumentoViaggio> query = em.createNamedQuery("Documento.puntoDiEmissione", DocumentoViaggio.class);
//        query.setParameter("startDate", startDate);
//        query.setParameter("endDate", endDate);
//        query.setParameter("id", idRivenditore);
//        return query.getResultList();
//    }


}
