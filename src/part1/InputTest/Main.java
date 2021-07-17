package part1.InputTest;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("inserisci tra numeri da confrontare per poi stamparne il >");
		System.out.println("inserisco il primo numero");
		int a = sc.nextInt();
		System.out.println("inserisco il secondo numero");
		int b = sc.nextInt();
		System.out.println("inserisco il terzo numero");
		int c = sc.nextInt();
		int temp;
		if (a > b){
			temp = a;
		}else{
			temp = b;
		}
		if(temp > c && temp == a){
			System.out.println("il numero > tra i 3 è " + temp + "ed è il primo numero");

		}else if(temp > c && temp == b){
			System.out.println("il numero > tra i 3 è " + temp +  "ed è il secondo numero");
		}
		else if (a == b && b == c && c == a){
			System.out.println("tutti e tre i numeri sono uguali");
		}
		else{
			System.out.println("il numero > tra i 3 è " + c + "ed è il terzo numero");
		}
    }
}
