package alessia.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Rivista extends ElementoLetterario {
@Enumerated(EnumType.STRING)
    Periodicita periodicita;

//CONSTRUCTORS


    public Rivista() {
    }

    public Rivista(int codiceIsbn, String titolo, int annoDiPubblicazione, int numeroDiPagine) {
        super(codiceIsbn, titolo, annoDiPubblicazione, numeroDiPagine);
    }

    public Rivista(int codiceIsbn, String titolo, int annoDiPubblicazione, int numeroDiPagine, Periodicita periodicita) {
        super(codiceIsbn, titolo, annoDiPubblicazione, numeroDiPagine);
        this.periodicita = periodicita;
    }


//GETTERS & SETTERS


    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }


//TO STRING


    @Override
    public String toString() {
        return "Rivista{" +
                "titolo=" + getTitolo() +
                " periodicita=" + periodicita +
                '}';
    }

}
