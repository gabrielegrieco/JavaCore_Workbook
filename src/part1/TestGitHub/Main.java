package part1.TestGitHub;
import java.util.Scanner;	 // se uso l'* al posto di scanner importo tutto;

public class Main {

    public static void main(String[] args) {
	System.out.println("Ciao");

	    int k = 5; // questa scrittura non ha metod'
	    Integer i = 23 + k;  // Integer è una costruzione che io faccio su questo numero e si chiama boxing, Integer in questo caso è un oggetto, i è un' ostanza della classe int
                             // e lo wrappa come oggetto della classe int
        long z = 20000;
        Long w = 1234567890l; // in questo caso il valore è stato boxato.

        // tutte le classi in Java discendono da degli antenati, in particolare dalla classe object e talvolta mi è utile trattare il numro come un oggetto.

	    Integer j = 20;
	    String s = i.toString();
	    long l = i.longValue();
	    short sh = i.shortValue();
	    i.compareTo(j);

	    boolean b;
	    b = false;
	    Boolean bb = true;
	    bb = false;

	    // TRUE e FALSE sono le costanti della classe Boolean
        bb = Boolean.TRUE; // questo è un valore oggetto boxing del valore .TRUE , mentre il true è primitivo;

        // Char
        char cc = 'a';
        char cc2 = 'h';
        Character ccb = cc; // Character è la classe che rappresenta il boxing per il char

        // tramite il \ posso fare riferimento a dei caratteri speciali

        char cr = '\n'; // ora questo carattere diventa un ritorno a capo : carriage return;

        String sampleString = "nome\ncognome";
        System.out.println(sampleString);

        // In Java gli array, collezioni di dati indicizate a partire da 0;

		int al = args.length; // errore di not a statement perchè ho bisogno di una variabile in cui sistemo il valore di lunghezza di args

		String[] sarr = new String[10]; // oggetto array di oggetti stringa
		sarr[0] = "pippo";
		sarr[9] = "pluto";
		sarr[8] = "topolino";

		// com chiedere in input degli argomenti, uso l'oggetto scanner;
		Scanner sc;
		sc = new Scanner(System.in); // riceve il testo e riconosce se è una stringa o un intero

		// chiedo inserimento di un numero;
		System.out.println("inserisci un numero");
		int n = sc.nextInt();
		System.out.println("hai inserito il numero: " + n);

		// metodi di scanner : nextInt, nextLine, nextLong

    }
}
