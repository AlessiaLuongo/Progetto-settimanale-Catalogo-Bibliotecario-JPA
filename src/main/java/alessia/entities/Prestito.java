package alessia.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "utente_id")

    private Utente utente;
    @OneToOne
    @JoinColumn(name = "elemento_prestato")
    private ElementoLetterario elementoPrestato;
    @JoinColumn(name = "data_inizio_prestito")
    private LocalDate dataInizio;
    @JoinColumn(name = "data_restituzione_prestito")
    private LocalDate dataRestituzionePrevista;
    @JoinColumn(name = "data_restituzione_prestito-effettiva")
    private LocalDate dataRestituzioneEffettiva;



// CONSTRUCTORS

    public Prestito(){};

    public Prestito(Utente utente, ElementoLetterario elementoPrestato, LocalDate dataInizio) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataInizio.plusDays(30);
        this.dataRestituzioneEffettiva = null;
    }

    public Prestito(int id, Utente utente, ElementoLetterario elementoPrestato, LocalDate dataInizio, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.id = id;
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
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

    public void setDataRestituzionePrevista(LocalDate getDataRestituzionePrevista) {
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
                "utente=" + utente.getNome() + utente.getCognome() +
                ", elementiPrestati=" + elementoPrestato +
                ", dataInizio=" + dataInizio +
                ", dataRestituzione=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }


}
