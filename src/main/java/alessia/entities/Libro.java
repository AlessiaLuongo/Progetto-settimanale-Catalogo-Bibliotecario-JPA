package alessia.entities;

import javax.persistence.Entity;

@Entity
public class Libro extends ElementoLetterario{
    private String autore;
    private String genere;


//CONSTRUCTORS

    public Libro(int codiceIsbn, String titolo, int annoDiPubblicazione, int numeroDiPagine) {
        super(codiceIsbn, titolo, annoDiPubblicazione, numeroDiPagine);
    }

    public Libro() {
        super();
    }

    public Libro(int codiceIsbn, String titolo, int annoDiPubblicazione, int numeroDiPagine, String autore, String genere) {
        super(codiceIsbn, titolo, annoDiPubblicazione, numeroDiPagine);
        this.autore = autore;
        this.genere = genere;
    }

//GETTERS & SETTERS


    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


//TO STRING
    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }


}
