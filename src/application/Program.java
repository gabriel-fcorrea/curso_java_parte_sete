package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		method1();

		System.out.println("End of program");

	}

	private static void method1() {
		method2();
	}

	private static void method2() {

		Scanner sc = new Scanner(System.in);

		try {
			String[] vect = sc.nextLine().split(" "); // split - separador de cada vetor
			int position = sc.nextInt(); // para capturar a posição do vetor
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
			e.printStackTrace(); // acusa o erro, o motivo e a sequência de chamadas que gerou a exceção
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error!");
		}

		sc.close();

	}

}
