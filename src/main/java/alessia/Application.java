package alessia;

import alessia.dao.ElementoLetterarioDAO;
import alessia.dao.PrestitoDAO;
import alessia.dao.UtenteDAO;
import alessia.entities.ElementoLetterario;
import alessia.entities.Libro;
import alessia.entities.Periodicita;
import alessia.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataBaseBibliotecario");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ElementoLetterarioDAO elementoLetterarioDAO = new ElementoLetterarioDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        Libro libro1 = new Libro(1234, "La Storia del Rock", 2008, 52, "Ezio Guaitamacchi", "musica");
        Libro libro2 = new Libro(4567, "Narnia", 1939, 505, "Clive Staples Lewis", "romanzo");
        Libro libro3 = new Libro(7890, "Harry Potter e il prigioniero di Askaban", 1999, 603, "Joanne Rowling", "romanzo");
        Libro libro4 = new Libro(1987, "Harry Potter e i Doni della Morte", 2007, 460, "Joanne Rowling", "romanzo");
        Libro libro5 = new Libro(1867, "Il libro delle ricette vegane", 2016, 57, "Alessia Luongo", "cucina");
        Libro libro6 = new Libro(1745, "La cucina vegetariana", 2020, 68, "Alessia Luongo", "cucina");
        Libro libro7 = new Libro(2668, "La Storia della Storia", 2018, 88, "Alessandro Barbero", "storia");
        Libro libro8 = new Libro(5669, "Gli occhi di Venezia", 2020, 432, "Alessandro Barbero", "storia");
        Rivista rivista1 = new Rivista(552, "Focus", 2005, 25, Periodicita.MENSILE);
        Rivista rivista2 = new Rivista(684, "Mille e una ricetta", 2015, 28, Periodicita.SEMESTRALE);
        Rivista rivista3 = new Rivista(547, "Intrattenimento dal parrucchiera", 1963, 42, Periodicita.SETTIMANALE);
        Rivista rivista4 = new Rivista(147, "Com'è fatto il corpo umano", 1998, 47, Periodicita.SEMESTRALE);

    // AGGIUNTA DI UN ELEMENTO AL CATALOGO

/*      elementoLetterarioDAO.save(libro1);
        elementoLetterarioDAO.save(libro2);
        elementoLetterarioDAO.save(libro3);
        elementoLetterarioDAO.save(libro4);
        elementoLetterarioDAO.save(libro5);
        elementoLetterarioDAO.save(libro6);
        elementoLetterarioDAO.save(libro7);
        elementoLetterarioDAO.save(libro8);
        elementoLetterarioDAO.save(rivista1);
        elementoLetterarioDAO.save(rivista2);
        elementoLetterarioDAO.save(rivista3);
        elementoLetterarioDAO.save(rivista4);
*/


    // RICERCA E RIMOZIONE DI UN ELEMENTO LETTERARIO ATTRAVERSO IL SUO CODICE ISBN


        elementoLetterarioDAO.findByIsbnAndDelete(4567);
    }
}
