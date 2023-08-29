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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkout = sdf.parse(sc.next());
			
			
			Reservation reserva = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + reserva);
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkout = sdf.parse(sc.next());
			
			reserva.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		
		sc.close();

	}


}