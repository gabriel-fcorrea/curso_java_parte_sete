package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExemploFinally {

	public static void main(String[] args) {

		File file = new File("C:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file: " + e.getMessage());
		} finally { // roda o final do código mesmo se der exceção durante o processamento
			if (sc != null) {
				sc.close();
			}
		}
	}
}
