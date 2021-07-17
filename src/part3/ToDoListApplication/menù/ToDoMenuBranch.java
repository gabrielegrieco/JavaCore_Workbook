package part3.ToDoListApplication.menù;


import ires.corso.ToDoImportExport;
import ires.corso.ToDoList;
import ires.corso.ToDoManager;

import java.util.*;

import static ires.corso.ToDo.stampa;

// OPZIONE: contiene altri elementi
public class ToDoMenuBranch extends ToDoMenuItem {
    private List<ToDoMenuItem> _options = new ArrayList<>();
    private boolean _exit;
    private final String _defaultExitMessage = "Indietro";

    // Public constructor
    public ToDoMenuBranch(String ID, String title, List<ToDoMenuItem> options) {
        super(ID, title);
        _options.addAll( options );
        String exitID = String.valueOf( _options.size() + 1 );
        initExit( exitID, _defaultExitMessage );
    }

    public ToDoMenuBranch(String ID, String title, List<ToDoMenuItem> options, String exitID, String exitMessage) {
        super(ID, title);
        _options.addAll( options );
        initExit( exitID, exitMessage );
    }

    private void initExit( String exitID, String exitMessage){
        ToDoMenuLeaf exitLeaf = new ToDoMenuLeaf( exitID, exitMessage, () -> _exit = true );
        _options.add( exitLeaf );
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);

        _exit = false;
        do {
            printContent();
            String choice = in.nextLine();
            Optional<ToDoMenuItem> selected = _options.stream().filter(o -> o.getID().equals( choice ) ).findFirst();
            if( selected.isPresent() )
                selected.get().run();
            else
                stampa.display( "L'opzione che hai selezionato non è valida." );
        }while( !_exit );
    }

    private void printContent() {
        stampa.display( getTitle() );
        _options.stream().map( ToDoMenuItem::toString ).forEach( stampa::display );
    }

    public static ToDoMenuBranch createMenu(){
        ToDoMenuLeaf byPriority = new ToDoMenuLeaf("1", "Per priorità", ToDoList::visualizzaPerPriorità );
        ToDoMenuLeaf byDate = new ToDoMenuLeaf("2", "Per data", ToDoList::visualizzaPerData );
        ToDoMenuLeaf byState = new ToDoMenuLeaf("3", "Per stato", ToDoList::visualizzaPerStato );
        ToDoMenuBranch visualizzaMenu = new ToDoMenuBranch("1", "Visualizza", Arrays.asList( byPriority, byDate, byState ));

        ToDoMenuLeaf addToDo = new ToDoMenuLeaf("1", "Aggiungi", ToDoManager::createNewToDo);
        ToDoMenuLeaf removeToDo = new ToDoMenuLeaf("2", "Rimuovi", ToDoManager::removeToDo );
        ToDoMenuLeaf editToDo = new ToDoMenuLeaf("3", "Modifica", ToDoManager::updateToDo );
        ToDoMenuBranch editMenu = new ToDoMenuBranch("2", "Aggiungi, Rimuovi, Modifica", Arrays.asList(addToDo, removeToDo, editToDo));

        ToDoMenuLeaf exportToDo = new ToDoMenuLeaf("1", "Export su file", ToDoImportExport::ExportDati );
        ToDoMenuLeaf importToDo = new ToDoMenuLeaf("2", "Import da file", ToDoImportExport::ImportaDati );
        ToDoMenuBranch importExportMenu = new ToDoMenuBranch("3", "Import/Export", Arrays.asList( exportToDo, importToDo ));

        ToDoMenuBranch mainMenu = new ToDoMenuBranch("MainMenu", "Menu Principale", Arrays.asList( visualizzaMenu, editMenu, importExportMenu ), "4", "Esci");
        return mainMenu;
    }
}
