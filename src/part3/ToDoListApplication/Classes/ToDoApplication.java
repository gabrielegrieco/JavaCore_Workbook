package part3.ToDoListApplication.Classes;

import ires.corso.ToDoListExercice.Utilities.ToDoUtilitiesApp;
import ires.corso.ToDoListExercice.Utilities.UtilitiesDiStampa;
import ires.corso.parttwo.todo.menu.ToDoMenuBranch;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ToDoApplication
    {
        static Integer sceltaUtente;
        static final String[] opzioni = {"Visualizza", "Aggiungi", "Modifica", "Elimina", "Import/Export", "Uscita"};
        static ToDoUtilitiesApp utilities = new ToDoUtilitiesApp();
        static final UtilitiesDiStampa stampa = new UtilitiesDiStampa();
        static ToDoRepository _repo = ToDoRepository.getToDoRepository();
        static  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");


        public static void main(String[]args) throws IOException, ClassNotFoundException, NoSuchMethodException {

            stampa.spazio();
            stampa.stampaTitolo();
            stampa.spazio();
            //ToDoRepository.caricaDaFile("Test1.bin");
            ToDoMenuBranch menu = ToDoMenuBranch.createMenu();
            menu.run();
            //ToDoRepository.writeToFile("Test1.bin");
        }
    }
