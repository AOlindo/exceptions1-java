package application;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data check-in (dd/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.print(reserva);

			System.out.println("");
			System.out.println("");
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Data check-in (dd/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());

			reserva.atualizarData(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);

		} catch (ParseException e) {
			System.out.println("Formato de data inválido");
		} catch (DominioException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();

	}
}
