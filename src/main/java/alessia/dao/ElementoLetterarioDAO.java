package alessia.dao;

import alessia.entities.ElementoLetterario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ElementoLetterarioDAO {

    private EntityManager em;

    public ElementoLetterarioDAO(EntityManager em) {
        this.em = em;
    }


    public void save(ElementoLetterario elementoLetterario) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(elementoLetterario);
            t.commit();
            System.out.println("Elemento Letterario - " + elementoLetterario.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
