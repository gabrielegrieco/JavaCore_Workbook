package part3.ToDoListApplication.Utilities;
import part3.ToDoListApplication.Classes.ToDoManager;

import java.util.Scanner;

public class ToDoUtilitiesApp {

    // aggregation
    static UtilitiesDiStampa stampa = new UtilitiesDiStampa();
    static private Scanner sc = new Scanner(System.in);
    static private ToDoManager manager = new ToDoManager();

    //metodi di utilities

    //validazione
    public Integer validazioneOpzioneScelta(String[] opzioni) {

        int sceltaUtente = sc.nextInt();
        if (1 <= sceltaUtente && sceltaUtente < 6) {
            stampa.display("hai scelto l'opzione " + opzioni[sceltaUtente - 1] + ".");
        } else if (sceltaUtente == 6) {
            stampa.spazio();
            stampa.display("sei sicuro di voler uscire? digita 1: SI, voglio uscire; 2: NO, ritorna al menu di partenza\n");
            int scelta = sc.nextInt();
            if (scelta == 1) {
                //
            }
            while (sceltaUtente >= opzioni.length || sceltaUtente < 1) {
                // ritorno nel loop
                stampa.stampaMenu(opzioni);
                stampa.spazio();
                validazioneOpzioneScelta(opzioni);
                stampa.display("l'opzione scelta non è valida, scegli un' altra opzione o premi " +
                        "'" + (opzioni.length) + "'" + " per uscire\n");
                sceltaUtente = sc.nextInt();
            }
        }
        return sceltaUtente;
    }

    // comportamento del programma
    public void OpzioneScelta(Integer scelta) {
        if (scelta == 1) {

        }
        else if (scelta == 2 || scelta == 3 || scelta == 4) {
            switch(scelta){
                case 2:

                    break; // aggiungi
                case 3:
                    manager.updateToDo();
                    break; // modifica

                case 4:
                    manager.removeToDo();
                    break; // rimuovi
            }
        }
        else if (scelta == 5) {
            // import/export
        }
    }

    public void prettyPrint(){

    }
}

