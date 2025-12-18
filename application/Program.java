package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.err.print("Room number: ");
            int number = sc.nextInt();
            System.err.println("Check-in date (dd/mm/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.err.println("Check-out date (dd/mm/yyyy)");
            Date checkOut = sdf.parse(sc.next());

        
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.err.println("Reservation: " + reservation);


            System.err.println("Enter data to update the reservation: ");
            System.err.println("Check-in date (dd/mm/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.err.println("Check-out date (dd/mm/yyyy)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.err.println("Reservation: " + reservation);
        }
        catch (ParseException e){
            System.err.println("Invalid date format");
        }
        catch(DomainException e){
            System.err.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.err.println("Unexpected error");
        }

        


        sc.close();
    }
}
