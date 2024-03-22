package alessia.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "utente")

    private Utente utente;
    @OneToOne
    @JoinColumn(name = "elemento_prestato")
    private ElementoLetterario elementoPrestato;
    private LocalDate dataInizio;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;



// CONSTRUCTORS

    public Prestito(){};

    public Prestito(Utente utente, ElementoLetterario elementoPrestato, LocalDate dataInizio, LocalDate dataRestituzione, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = getDataInizio();
        this.dataRestituzionePrevista = getDataRestituzionePrevista();
        this.dataRestituzioneEffettiva = getDataRestituzioneEffettiva();
    }

    // GETTERS & SETTERS


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoLetterario getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoLetterario elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void etDataRestituzionePrevista(LocalDate getDataRestituzionePrevista) {
        this.dataRestituzionePrevista = getDataInizio().plusDays(30);
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

// TO STRING


    @Override
    public String toString() {
        return "Prestito{" +
                "utente=" + utente +
                ", elementiPrestati=" + elementoPrestato +
                ", dataInizio=" + dataInizio +
                ", dataRestituzione=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
