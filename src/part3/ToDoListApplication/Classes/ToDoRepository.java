package part3.ToDoListApplication.Classes;

import java.io.*;
import java.util.*;

public class ToDoRepository implements Serializable
{
    //------------------------------------------------------------------------------------------------------------------ fields

    private static ToDoRepository _repository = null;
    Map<Long, ToDo> _data = new HashMap<>();
    private static long nextID = 0;

    //------------------------------------------------------------------------------------------------------------------ "constructors"

    private ToDoRepository(){};
    public static ToDoRepository getToDoRepository() {
        if(_repository == null){
            _repository = new ToDoRepository();
        }
        return _repository;
    }

    //------------------------------------------------------------------------------------------------------------------ crud

    public static long nextID(){
        return ++_repository.nextID;
    }

    public void elimina(Long ID) {
        _repository._data.remove(ID);
    };

    public static void aggiugi(ToDo t) {
        long idT = t.getID();
        _repository._data.put(idT, t);
    }

    public void modifica(ToDo t) {
        long idT = t.getID();
        ToDo toDotoUpdate = _data.get(idT);
        _repository._data.put(idT, toDotoUpdate);
    }

    public static void clear (){_repository._data.clear();}

    public static boolean has(long ID) {
        return _repository._data.containsKey(ID);
    }

    public static ToDo getToDo(long ID){
        return _repository._data.get( ID );
    }

    public static void writeToFile(String fileName) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream objOut = new ObjectOutputStream(file);
        objOut.writeObject(_repository);
        objOut.close();
        file.close();
    }

    public static void leggiDaFile(String fileName) throws IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        _repository = (ToDoRepository) in.readObject();
    }

    public static ToDoRepository caricaDaFile(String fileName) throws ClassNotFoundException, IOException {
        leggiDaFile(fileName);
        if (_repository == null) {
            _repository = new ToDoRepository();
        }
        return _repository;
    }


    public static List<ToDo> getToDoList() {
        return new ArrayList<ToDo>(_repository._data.values());
    }
    //------------------------------------------------------------------------------------------------------------------
}