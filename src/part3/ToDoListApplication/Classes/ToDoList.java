package part3.ToDoListApplication.Classes;

import ires.corso.ToDoListExercice.Utilities.UtilitiesDiStampa;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ToDoList {

    static UtilitiesDiStampa stampa = new UtilitiesDiStampa();

    public static void visualizzaLista( String msg, Function<ToDo, Comparable> field ) {
        stampa.display(msg);
        List<ToDo> sortedList = ToDoRepository.getToDoList();
        Comparator<ToDo> comparator = Comparator.comparing( field );
        sortedList.sort( comparator );
        prettyPrint( sortedList );
    }

    private static void prettyPrint(List<ToDo> sortedList) {
        sortedList.stream().map( ToDo::prettyPrint ).forEach(UtilitiesDiStampa::displayy);
    }

    public static void visualizzaPerPriorità() {
        visualizzaLista("ordino la lista per priorità\n", ToDo::getPriorità);
    }
    public static void visualizzaPerStato(){
        visualizzaLista("ordino la lista per stato\n", ToDo::getStato);
    }
    public static void visualizzaPerData(){
        visualizzaLista("ordino lista per data\n", ToDo::getDataConsegna);
    }
}
