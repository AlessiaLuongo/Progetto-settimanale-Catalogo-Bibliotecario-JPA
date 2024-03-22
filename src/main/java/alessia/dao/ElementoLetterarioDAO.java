package alessia.dao;

import alessia.entities.ElementoLetterario;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
    public ElementoLetterario findByIsbn(int codiceIsbn) {
        return em.find(ElementoLetterario.class, codiceIsbn);
    }


    public ElementoLetterario findElementoPerIsbn(int codiceIsbn){
        TypedQuery<ElementoLetterario> query = em.createNamedQuery("ricercaPerIsbn", ElementoLetterario.class);
        query.setParameter("codiceIsbn", codiceIsbn);
        return query.getSingleResult();
    }

    public void findByIsbnAndDelete(int codiceIsbn) {
        try {
            EntityTransaction t = em.getTransaction();
            ElementoLetterario found = em.find(ElementoLetterario.class, codiceIsbn);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento letterario: " + found.getTitolo() + " eliminato");
            } else System.out.println("Elemento letterario non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
