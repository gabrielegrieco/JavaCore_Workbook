package part3.ToDoListApplication.Utilities;

public class ExerciceDescription {
    /*
            ANALISI - RISULTATO
        ---------------
        01. Visualizza:
        ---------------
        PREREQUISITI
            - esiste una lista di TO-DO mantenuta in una collection (classe che "mantiene" questa lista)
            - quando l'utente sceglie di visualizzare la lista, la collection è usata
              per stampare a video tutti i TO-DO
            - le diverse opzioni di filtro sono applicate alla lista, che quindi deve essere
              "filtrabile" secondo i vari criteri
            - Enumeration per priorità e per lo stato ==> nella classe TO-DO
		01. PER PRIORITA'
			- ordinamento per priorità: arrayList di tutti i TO-DO organizzati con il metodo sort in base alla priorità.
			- quando l'utente sceglie questa azione, lo schermo viene "pulito" e si mostra la lista dei TO-DO ordinati
			  per priorità
			- l'ordinamento deve essere scritto esplicitamente
			- ***PLUS*** da fare per chi riesce: applicazione di filtro fra valori priorità: ALTA, MEDIA, BASSA: quando
			  l'utente sceglie una priorità verranno mostrati solo i TO-DO con quel determinato valore.
		02. PER DATA
			- ordinamento per data: arrayList.sort(tutti i to do ordinati)
			- quando l'utente sceglie questa azione, lo schermo viene "pulito" e si mostra la lista dei TO-DO ordinati
			  per data
			- l'ordinamento deve essere scritto esplicitamente
		03. PER STATO
			- ordinamento per stato: arrayList di tutti i TO-DO organizzati con il metodo sort in base allo stato
			- quando l'utente sceglie questa azione, lo schermo viene "pulito" e si mostra la lista dei TO-DO ordinati
			  per stato
			- l'ordinamento deve essere scritto esplicitamente
			- ***PLUS*** da fare per chi riesce: applicazione di filtro fra valori dello stato: "DA FARE" "IN ESECUZIONE" ,
			  "COMPLETATA", "ANNULLATA": quando l'utente sceglie una priorità verranno mostrati solo i TO-DO con
			  quel determinato valore.
        --------------------------------
        02. Aggiungi, Modifica, Rimuovi:
        --------------------------------
        PREREQUISITI
            - suggeriamo utilizzo di HashMap<ID, oggetto TO-DO>
            - ID è un campo “auto-incrementale” che andrà salvato nel file di output
            - campi privati con Getter e Setter
            - FINAL solamente DataCreazione, ID
            - Aggiungi e Modifica possono usare uno stesso metodo
            - deve esistere una classe che gestisca input di un valore con loop da utilizzare per
              i diversi campi (cfr. metodi "askForInput" di lettore)
            - i metodi di input devono prevedere:
              1) un messaggio da stampare a video
              2) delle restrizioni di formato (es. per inserire data, oppure un set di valori)
              3) uscita
        01. AGGIUNGI:
            - chiama subito costruttore “vuoto” dell’oggetto TO-DO
            - al momento della costruzione si "stacca" un nuovo ID
            - il metodo chiede le varie voci… (potenzialmente usando un metodo prettyPrint del TO-DO)
	            TITOLO:
	            DESCRIZIONE:
	            STATO:
	            DATA CONSEGNA:
	            PRIORITà: (scegliere tra valori ENUM)
            - Poi fa inserire all’utente i dati che vuole cambiare del TO-DO (tramite i metodi SETTER del TO-DO),
              mostrando una voce alla volta, deve esserci un loop che accetta stringhe, oppure una data, oppure un set
              di valore prestabiliti (es. priorità: 1, 2, o 3), più # per uscire
            - Se l’utente non inserisce nulla o solo spazi, la voce non viene cambiata. Altrimenti il campo viene
              cambiato con il nuovo input inserito.
            - Conferma aggiunta di oggetto TO-DO alla collection.
        02. MODIFICA:
            - copia TO-DO esistente e fa uno “swap” delle 2 voci una volta confermato
            - utilizzare un metodo cloneForUpdate(), che crea un nuovo TO-DO copiandoci tutti i valori
            - utente scrive l’ID del TO-DO da modificare dalla collection: controllare se l’ID inserito esiste
            - trovato l’ID nella collection, il programma mostra le varie voci… (potenzialmente usando un metodo
              prettyPrint del TO-DO)
	            TITOLO: valore del campo titolo
	            DESCRIZIONE: valore del campo descrizione
	            STATO: valore del campo stato
	            DATA CONSEGNA: valore del campo data consegna
	            PRIORITà: valore del campo priorità
            - poi fa inserire all’utente i dati che vuole cambiare del TO-DO (tramite i metodi SETTER del TO-DO),
              mostrando una voce alla volta
            - Se l’utente non inserisce nulla o solo spazi, la voce non viene cambiata: altrimenti il campo viene
              cambiato con il nuovo input inserito
            - si chiede conferma finale della modifica del TO-DO
        03. RIMUOVI:
            - utente scrive l’ID del TO-DO da eliminare dalla collection
            - controllare se l’ID inserito esiste
            - chiedere una conferma di eliminazione con “pretty print” del record in fase di eliminazione
            - poi elimina definitivamente
        N.B. Da controllare potenziali conflitti con I/O.
        Ogni volta che fai un’operazione di write/read chiami anche il I/O per aggiornare il file “di salvataggio”
        -> da scegliere tra prestazioni e funzionalità
        ---------------------------
        03. Import/Export + Uscita:
        ---------------------------
        PREREQUISITI
            - il formato di input/output deve essere definito da qualche parte
            - non è possibile importare ID: ogni TO-DO del file di import sarà creato con un nuovo ID
              generato al momento del suo caricamento da file
            - anche la data di creazione sarà "staccata" al momento del caricamento
            - nell'export TUTTI i campi possono essere pubblicati
        01. IMPORT
        ----------
            - all'utente viene chiesto da che file importare
            - si chiede anche se si desidera: A. sovrascrivere, B. aggiungere le issues alla lista
            - si controlla se il file esiste
            - se non esiste, si segnala un errore
            - se esiste, si creano gli oggetti per leggere le righe
            - per ciascuna riga letta, si verifica se il formato è corretto
            - l'import sostituisce/amplia la lista a seconda della richiesta dell'utente
        02. EXPORT
        ----------
            - all'utente viene chiesto in che file esportare
            - si controlla se il file esiste
            - se esiste, si segnala un errore
            - se non esiste, si creano gli oggetti per scrivere le righe
            - loop di scrittura su file
        03. USCITA
        ----------
            - messaggio di conferma: sei sicuro di voler uscire?
            - si chiede successivamente se si desidera anche salvare le modifiche (sempre)
        -----------------------
        04. Persistenza e Menu:
        -----------------------
        01. GESTIONE MENU
            - Il menù sarà gestito tramite un ciclio while che avrà al suo interno degli switch
              per le voci del menù principale e altri switch per il sottomenù.
            - I sottomenù avranno un tasto per tornare al menù principale.
        02. SALVATAGGIO
            - Ipotesi 1. Implementare una conversione da oggetto TO-DO a stringhe da salvare in un
              file.txt alla chiusura(e/o ad ogni variazioni nella TO-DO list) e una coversione da stringhe a TO-DO
              da file all'apertura del programma.
            - Ipotesi 2. Serializzare tutta la lista di TO-DO con writeObject.
     */
}
