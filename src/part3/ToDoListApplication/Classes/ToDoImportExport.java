package part3.ToDoListApplication.Classes;

import part3.ToDoListApplication.Utilities.UtilitiesDiStampa;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ToDoImportExport {

    private static final UtilitiesDiStampa stampa = new UtilitiesDiStampa();
    static ToDoRepository _repo = ToDoRepository.getToDoRepository();

    public static void ExportDati() {

        try {
            File file = new File("C:\\ires\\ToDoList\\ToDoList.txt");
            FileWriter fw = new FileWriter(file.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(fw);
            for(ToDo toDo: _repo.getToDoList() ){
                String s = toDo.esportaStringa();
                bw.write(s);
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ImportaDati() {

       stampa.display("Su quale file vuoi fare l'import?");
        String filePath = stampa.Scan();
        Path inputFile = Paths.get( filePath );
        List<List<String>> todoData = new ArrayList<>();

        try( BufferedReader reader = Files.newBufferedReader(inputFile, Charset.defaultCharset()) ){
            String lineaDaFile = "";
            List<String> todoString = new ArrayList<>();
            while ((lineaDaFile = reader.readLine()) != null) {
                if( lineaDaFile.length() == 0 ){
                    todoData.add( todoString );
                    todoString = new ArrayList<>();
                }
                else
                    todoString.add( lineaDaFile );
            }
        }
        catch (NoSuchFileException e){
            stampa.display("Errore, il file non esiste.");
            return;
        }
        catch (IOException e){
            e.printStackTrace();
            return;
        }
            stampa.display("Vuoi sovrascrivere tutti i ToDo con quelli importati? (s/n)");
            boolean sovrascrivi = stampa.Scan().toLowerCase().equals("s");
            if( sovrascrivi )
            {ToDoRepository.clear();}
            System.out.println(String.valueOf(todoData.size()));
            todoData.stream().map( ToDo::creaToDoDaStringa ).forEach( ToDo -> ToDoRepository.aggiugi(ToDo));
            stampa.spazio();

            stampa.display( "I ToDo sono stati importati.\n" );

            Collection<ToDo> list = _repo.getToDoList();
            todoData.stream().map( ToDo::creaToDoDaStringa ).forEach( toDo -> stampa.display(toDo.prettyPrint()));
        }
    }

