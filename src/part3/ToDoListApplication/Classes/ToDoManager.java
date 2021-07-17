package part3.ToDoListApplication.Classes;


import part3.ToDoListApplication.Utilities.UtilitiesDiStampa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ToDoManager {

    static UtilitiesDiStampa stampa = new UtilitiesDiStampa();
    static ToDoRepository repository = ToDoRepository.getToDoRepository();

    //------------------------------------------------------------------------------------------------------------------ metodi
    public static void createNewToDo() {

        ToDo t = new ToDo();
        chiediTodo(t, false);
        repository.aggiugi(t);
    }

    public static void removeToDo(){
        stampa.display("inserisci l' ID del ToDo da eliminare.");
        Long ID = Long.parseLong(stampa.Scan());
        if(!ToDoRepository.has(ID)){
            stampa.display("il ToDo non esiste");
        }
        else{
            ToDo t = ToDoRepository.getToDo(ID);
            stampa.display(t.getTitolo());
            stampa.display("vuoi procedere nell' eliminazione di questo ToDo? s/n");
            String risp = stampa.Scan();
            if(risp.toLowerCase().equals("s"))
                return;
            repository.elimina(ID);
            stampa.display("Il ToDo è stato eliminato");
        }
    }

    public void aggiornamento(ToDo t, boolean aggiornato){
        String input;
        if(aggiornato){
            stampa.display("Inserisci i dati, lascia il campo vuoto se vuoi mantenere i dati originali");
        }else{
            stampa.display("inseerisci i dati:");

            stampa.display("titolo");
            input = stampa.Scan();
            if(!(aggiornato && input.isEmpty()) )
                t.setTitolo(input);
            if(!(aggiornato && input.isEmpty()) )
                t.setDescrizione(input);

            ToDo.stato stato = richiestaStato(t, aggiornato);
            t.setStato(stato);
            ToDo.priorità priorità = richiestaPriorità(t, aggiornato);
            t.setPriorità(priorità);

            stampa.display("Data (" + ToDo.dateFormat + "): " );
            LocalDateTime data = richiestaData(ToDo.getDateFomatter(), aggiornato);
            if(data != null){
                t.setDataConsegna(data);
            }
        }
    }

    public static void updateToDo(){
        ToDo t = new ToDo();
        chiediTodo( t, false );
        stampa.display( t.prettyPrint() );
        stampa.display("Vuoi creare questo ToDo? (s/n)");
        String input = stampa.Scan();
        if( input.toLowerCase().equals("s") ) {
            ToDoRepository.aggiugi(t);
            stampa.display("Il ToDo è stato aggiunto.\n");
        }
    }
    //------------------------------------------------------------------------------------------------------------------ metodi static
    private static ToDo.stato richiestaStato( ToDo t, boolean isEdit ){
            ToDo.stato stato = null;
            boolean valid;
            do {
                valid = true;
                stampa.display( "Stato (1: DA_FARE, 2: IN_ESECUZIONE, 3: COMPLETATA, 4: ANNULLATA): " );
                String input = stampa.Scan();
                switch (input) {
                    case "1": stato = ToDo.stato.DA_FARE; break;
                    case "2": stato = ToDo.stato.IN_ESECUZIONE; break;
                    case "3": stato = ToDo.stato.COMPLETATA; break;
                    case "4": stato = ToDo.stato.ANNULLATA; break;
                    case "":
                        if( isEdit ){
                            stato = t.getStato();
                            break;
                        }
                    default:
                        stampa.display("Errore, lo stato non è valido, riprova.");
                        valid = false;
                }
            }while( !valid );

            return stato;
        }

    private static ToDo.priorità richiestaPriorità( ToDo t, boolean isEdit ){
            ToDo.priorità priority = null;
            boolean valid;
            do {
                valid = true;
                stampa.display( "Priorità (1: ALTA, 2: MEDIA, 3: BASSA): " );
                String input = stampa.Scan();
                switch (input) {
                    case "1": priority = ToDo.priorità.ALTA; break;
                    case "2": priority = ToDo.priorità.MEDIA; break;
                    case "3": priority = ToDo.priorità.BASSA; break;
                    case "":
                        if( isEdit ){
                            priority = t.getPriorità();
                            break;
                        }
                    default:
                        stampa.display("Errore, la priorità non è valida, riprova.");
                        valid = false;
                }
            }while( !valid );

            return priority;
        }

    public static LocalDateTime richiestaData(DateTimeFormatter dtf, boolean allowBlank ){
            LocalDateTime result = null;
            boolean valid = false;
            do {
                String str = stampa.Scan();
                try {
                    result = LocalDateTime.parse(str, dtf);
                }
                catch ( DateTimeParseException e ){
                    if( allowBlank && str.isEmpty() )
                        valid = true;
                    else {
                        stampa.display("Errore, la stringa inserita non è una data, riprova.");
                        continue;
                    }
                }
                valid = true;
            }while(!valid);
            return result;
        }

    private static void chiediTodo( ToDo t, boolean isEdit ){
        String input;
        if( isEdit )
            stampa.display("Inserisci i dati, lascia il campo vuoto se vuoi mantenere gli originali:");
        else
            stampa.display("Inserisci i dati:");

        stampa.display("Titolo: ");
        input = stampa.Scan();
        if( !(isEdit && input.isEmpty()) )
            t.setTitolo( input );

        stampa.display("Descrizione:  ");
        input = stampa.Scan();
        if( !(isEdit && input.isEmpty()) )
            t.setDescrizione( input );

        ToDo.stato stato = richiestaStato( t, isEdit );
        t.setStato( stato );

        ToDo.priorità priority = richiestaPriorità( t, isEdit );
        t.setPriorità( priority );

        stampa.display( "Data (" + ToDo.dateFormat + "): " );
        LocalDateTime date = richiestaData(  ToDo.getDateFomatter(), isEdit );
        if( date != null )
            t.setDataConsegna( date );
    }
}
