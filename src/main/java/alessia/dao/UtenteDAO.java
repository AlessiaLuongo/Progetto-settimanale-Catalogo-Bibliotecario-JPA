package alessia.dao;

import alessia.entities.ElementoLetterario;
import alessia.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {

    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Utente utente) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(utente);
            t.commit();
            System.out.println("Utente - " + utente.getNome() + utente.getCognome() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
