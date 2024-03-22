package alessia.dao;

import alessia.entities.ElementoLetterario;
import alessia.entities.Prestito;
import net.bytebuddy.asm.Advice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

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


    public void savePrestito(Prestito prestito) {
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

    public void updateDataRestituzione(Prestito prestito, LocalDate dataRestituzioneEffettiva) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            prestito.setDataRestituzioneEffettiva(dataRestituzioneEffettiva);
            em.merge(prestito);
            t.commit();
            System.out.println("Il prestito di - " + prestito.getUtente() + " - è stato restituito!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
