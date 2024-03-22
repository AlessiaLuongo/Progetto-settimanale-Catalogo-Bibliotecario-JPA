package alessia.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_di_elemento_letterario")
@NamedQuery(name="ricercaPerIsbn", query = "SELECT e FROM ElementoLetterario e WHERE e.codiceIsbn = :codiceIsbn")
@NamedQuery(name="ricercaPerAnnoDiPubblicazione", query = "SELECT e FROM ElementoLetterario e WHERE e.annoDiPubblicazione = :annoDiPubblicazione")
@NamedQuery(name = "ricercaPerAutore", query = "SELECT libro FROM Libro libro WHERE libro.autore = :autore")
public abstract class ElementoLetterario {
    @Id
    private int codiceIsbn;
    private String titolo;
    @JoinColumn(name = "anno_di_pubblicazione")
    private int annoDiPubblicazione;
    @JoinColumn(name = "numero_di_pagine")
    private int numeroDiPagine;

@OneToOne(mappedBy = "elementoPrestato", cascade = CascadeType.REMOVE)
private Prestito prestito;

// CONSTRUCTORS

    public ElementoLetterario(int codiceIsbn, String titolo, int annoDiPubblicazione, int numeroDiPagine) {
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoDiPubblicazione = annoDiPubblicazione;
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

    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
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

    @Override
    public String toString() {
        return "ElementoLetterario{" +
                "codiceIsbn=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoDiPubblicazione=" + annoDiPubblicazione +
                ", numeroDiPagine=" + numeroDiPagine +
                '}';
    }
}


