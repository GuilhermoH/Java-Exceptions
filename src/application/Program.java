package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room number:");
			int number = sc.nextInt();
			System.out.println("Enter check In: dd/mm/yyyy");
			Date date = sdf.parse(sc.next());
			System.out.println("Enter check Out: dd/mm/yyyy");
			Date date2 = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, date, date2);
			System.out.println("Reservation- " + reservation.toString());

			System.out.println("");
			System.out.println("UPDATE RESERVATION");
			System.out.println("Enter check In: dd/mm/yyyy");
			date = sdf.parse(sc.next());
			System.out.println("Enter check Out: dd/mm/yyyy");
			date2 = sdf.parse(sc.next());
			reservation.updateDates(date, date2);
			System.out.println("Reservation- " + reservation.toString());
		}

		catch (DomainException r) {
			System.out.println(r.getMessage());
		}
		catch(ParseException x) {
			System.out.println("Format error");
		}
		catch(RuntimeException e) {
			System.out.println("ERROR");
		}
	}
}
