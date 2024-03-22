package alessia.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_di_elemento_letterario")
public abstract class ElementoLetterario {
    @Id
    private int codiceIsbn;
    private String titolo;
    private LocalDate annoDiPubblicazione;
    private int numeroDiPagine;

@OneToOne(mappedBy = "elementoPrestato")
private Prestito prestito;

// CONSTRUCTORS

    public ElementoLetterario(int codiceIsbn, String titolo, int annoDiPubblicazione, int numeroDiPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoDiPubblicazione = getAnnoDiPubblicazione();
        this.numeroDiPagine = numeroDiPagine;
    }

    public ElementoLetterario() {

    }

// GETTERS & SETTERS


    public int getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(int codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = LocalDate.now();
    }

    public int getNumeroDiPagine() {
        return numeroDiPagine;
    }

    public void setNumeroDiPagine(int numeroDiPagine) {
        this.numeroDiPagine = numeroDiPagine;
    }


    public Prestito getPrestito() {
        return prestito;
    }

}


