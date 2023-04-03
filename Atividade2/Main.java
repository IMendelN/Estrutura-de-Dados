package Atividade2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Escreva os valores de xA, yA e xB, yB respesctivamente: ");
		double xA = sc.nextDouble();
		double yA = sc.nextDouble();
		double xB = sc.nextDouble();
		double yB = sc.nextDouble();
		
		PontoCartesiano p = new PontoCartesiano(xA, yA, xB, yB);

		System.out.println(p.distance());
        sc.close();
	}

}
