/**
 * 
 */
package com.jonathan.ruleta;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Jonathan Arroyo
 *
 */
public class Ruleta {

	/**
	 * @param args
	 */

	public final static int P_1 = 7;
	public final static int P_2 = 5;
	public final static int P_3 = 10;
	private static TreeSet<Long> num = new TreeSet<Long>();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.out.println("!!!Bienvenido a la ruleta digital!!!");
		System.out.println("Para salir ingrese dos ceros (0) separados de un espacio en blanco");

		System.out.println("");

		String input = "";
		Scanner scanIn = new Scanner(System.in);

		long n, m;
		int k;

		while (true) {

			System.out.println("");
			System.out.println("1.Ingrese la primera línea, dos números positivos separados por un espacio en blanco");

			System.out.println(
					"El primer número no puede ser menor que 1 y mayor que 10^7 y el segundo no puede ser menor que 0 y mayor que 10^5: ");
			input = scanIn.nextLine();

			if (input.equals("0 0")) {
				break;
			}

			try {
				String[] temp = input.split(" ");

				if (temp.length != 2) {
					System.out.println("Solo se pueden ingresar 2 números");
					break;
				}

				n = Long.parseLong(temp[0]);
				m = Long.parseLong(temp[1]);

				if (!validarLimite(n, true)) {
					System.out.println("El primer número debe ser mayor que 0 y menor que " + P_3 + "^" + P_1);
					break;
				}

				if (!validarLimite(m, false)) {
					System.out.println(
							"El segundo número deber ser mayor o igual que cero y menor que " + P_3 + "^" + P_1);
					break;
				}

				System.out.println("");

				System.out.println(
						"2. Ingrese la segunda línea (grado del polinomio), un número entero positivo no mayor a 10:");
				input = scanIn.nextLine();
				k = Integer.parseInt(input);

				System.out.println("");

				System.out.println(
						"3. Ingrese la tercera línea, " + (k + 1) + " número(s) separados por espacios en blanco:");
				input = scanIn.nextLine();
				temp = input.split(" ");
				if (temp.length != k + 1) {
					System.out.println("La cantidad ingresada de número(s) no es igual al grado del polinomio");
					break;
				}

				long coeficiente[] = new long[k + 1];
				for (int i = 0; i <= k; i++) {
					coeficiente[i] = Long.parseLong(temp[i]);
				}

				num.clear();
				if (m <= n) {
					for (int t = 0; t <= m; t++) {
						num.add(evaluar(coeficiente, k, t, n));
					}
				} else {
					for (int t = 0; t <= n; t++) {
						num.add(evaluar(coeficiente, k, t, n));
					}
				}

				System.out.println("");
				System.out.println("La cantidad de números diferentes para la ruleta son:");
				System.out.println(num.size());

			} catch (NumberFormatException e) {
				System.out.println("El valor ingresado no es un número");
				break;
			}
		}

		scanIn.close();
		System.out.println("");
		System.out.println("Adios!!");

	}

	private static boolean validarLimite(long v, boolean esN) {
		if (esN) {
			if (1 <= v && v <= Math.pow(P_3, P_1)) {
				return true;
			}
		} else {
			if (0 <= v && v <= Math.pow(P_3, P_2)) {
				return true;
			}
		}
		return false;
	}

	private static long evaluar(long[] c, int d, long t, long n) {
		long s = 0;
		for (int i = d; i >= 0; --i) {
			s *= t;
			s += c[i];
			s %= (n + 1);
		}
		return (s % (n + 1));
	}

}
