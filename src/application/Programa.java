package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data check-in (dd/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data check-out (dd/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
			
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.print(reserva);

			System.out.println("");
			System.out.println("");
			System.out.println("Insira os dados para atualizar a reserva: ");
			System.out.print("Data check-in (dd/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro na reserva: as datas da reserva para atualização devem ser datas futuras");
				
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
				
			} else {
				reserva.atualizarData(checkIn, checkOut);
				System.out.println(reserva);
			}

		}

		sc.close();

	}

}
