package part3.ToDoListApplication.Classes;
import part3.ToDoListApplication.Utilities.UtilitiesDiStampa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ToDo implements Serializable
{
    protected enum priorità{ALTA, MEDIA, BASSA};
    protected enum stato{DA_FARE, IN_ESECUZIONE, COMPLETATA, ANNULLATA};

    public final static UtilitiesDiStampa stampa = new UtilitiesDiStampa();
    public final static String dateFormat = "dd-MM-yyyy HH:mm";

    //------------------------------------------------------------------------------------------------------------------
    // properties
    private long id;
    private String titolo;
    private String descrizione;
    private LocalDateTime dataInserimento;
    private LocalDateTime dataConsegna;
    private priorità priorità;
    private stato stato;

    public ToDo(String titolo, String descrizione, LocalDateTime dataInserimento, LocalDateTime dataConsegna, priorità p, stato s){
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.dataInserimento = dataInserimento;
        this.dataConsegna = dataConsegna;
        id = ToDoRepository.nextID();
        priorità = p;
        stato = s;
    }
    public ToDo(){
        id = ToDoRepository.nextID();
        dataInserimento = LocalDateTime.now();
    }

    //------------------------------------------------------------------------------------------------------------------ metodi

    public ToDo cloneForUpdate(ToDo daCopiare) {
        ToDo t = daCopiare;
        return t;
    }

    public String esportaStringa(){
            return String.format("dataInserimento:%s\ntitolo:%s\ndescrizione:%s\nstato:%s\npriorità:%s\ndata consegna:%s\n",
                    formatDate(dataInserimento), titolo, descrizione, stato.name(), priorità.name(), formatDate(dataConsegna));
    }

    public static DateTimeFormatter getDateFomatter(){
        return DateTimeFormatter.ofPattern(dateFormat);
    }

    private static LocalDateTime getDateDaStringa(String s){
        LocalDateTime ldt = null;
        try {
            ldt = LocalDateTime.parse(s, getDateFomatter());
        }
        catch ( DateTimeParseException e ){
            stampa.display("Errore durante l'importazione del file. La data inserita non è valida.");
        }
        return ldt;
    }

    public static String formatDate(LocalDateTime date){
        return date.format( getDateFomatter() ).toString();
    }

    public static ToDo creaToDoDaStringa(List<String> stringsList){

        ToDo t = new ToDo();
        for(String s : stringsList){
            int separatore = s.indexOf(":");
            String key = s.substring(0,separatore);
            String value = s.substring(separatore + 1);
            switch (key){
                case "data inserimento": t.setDataInserimento(value);
                    break;
                case "titolo": t.setTitolo(value);
                    break;
                case "descrizione": t.setDescrizione(value);
                    break;
                case "stato":
                    ToDo.stato stato = t.stato.valueOf(value.toUpperCase());
                    t.setStato(stato);
                    break;
                case "priorità":
                    ToDo.priorità priorità = t.priorità.valueOf(value.toUpperCase());
                    t.setPriorità(priorità);
                    break;
                case "data consegna": t.setDataConsegna(value);
                    break;
                default:
                    stampa.display("Errore, chiave non valida");
            }
        }
        return t;
        // in questo metodo considero la lista che mi arriva dal txt come fosse una hash anche se non lo è realmente,
        // infatti io scrivo come riferimento un titolo: .... ecc ecc e mi conviene usare la stessa impostazione mentale di
        // chiave e valore come la hashmap per "separare" i dati che mi serve pescare per costruire il toDo.
    }

    //------------------------------------------------------------------------------------------------------------------  getters

    public LocalDateTime getDataInserimento() {
        return dataInserimento;
    }

    public LocalDateTime getDataConsegna() {
        return dataConsegna;
    }

    public long getID() {
        return this.id;
    }

    public String getTitolo() {
        return titolo;
    }

    public ToDo.priorità getPriorità() {
        return priorità;
    }

    public ToDo.stato getStato() {
        return stato;
    }

    public Long getId(){return id;}

    public String getDescrizione(){return descrizione;}

    //------------------------------------------------------------------------------------------------------------------ setters

    public void setDataConsegna(LocalDateTime dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public void setDataConsegna(String s){
        LocalDateTime ldt = getDateDaStringa( s );
        this.dataConsegna = ldt;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

    public void setPriorità(ToDo.priorità priorità) {
        this.priorità = priorità;
    }

    public void setStato(ToDo.stato stato) {
        this.stato = stato;
    }

    public void setDataInserimento(String s){
        LocalDateTime ldt = getDateDaStringa(s);
        this.dataInserimento = ldt;
    }

    //------------------------------------------------------------------------------------------------------------------
    public String prettyPrint() {
        return String.format(
                "ID: %d, titolo: %s, descrizione: %s, stato: %s, priorità: %s, data consegna: %s\n",
                id, titolo, descrizione, stato.name(), priorità.name(), formatDate(dataConsegna)
        );
    }
}
