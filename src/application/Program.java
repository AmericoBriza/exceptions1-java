package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Room number: ");
		int room = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkout = sdf.parse(sc.next());
		
		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else { 
			Reservation reserva = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + reserva);
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkin2 = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkout2 = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin2.before(checkin) || checkout2.before(checkin)) {
				System.out.println("Error in reservation: Reservation dates for update must be future");
			}
			else if (!checkout2.after(checkin2)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reserva.updateDates(checkin2, checkout2);
				System.out.println("Reservation: " + reserva);
			}			
		}
		
		
		sc.close();

	}


}