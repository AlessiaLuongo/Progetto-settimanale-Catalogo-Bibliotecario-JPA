package alessia.dao;

import alessia.entities.ElementoLetterario;
import alessia.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Prestito prestito) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(prestito);
            t.commit();
            System.out.println("Prestito di- " + prestito.getUtente() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
