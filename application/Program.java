package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.err.print("Room number: ");
        int number = sc.nextInt();
        System.err.println("Check-in date (dd/mm/yyyy)");
        Date checkIn = sdf.parse(sc.next());
        System.err.println("Check-out date (dd/mm/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.err.println("Error int reservatioon: Check-out date must be after check in date");
        } else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.err.println("Reservation: " + reservation);
            System.err.println("Enter data to update the reservation: ");
            System.err.println("Check-in date (dd/mm/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.err.println("Check-out date (dd/mm/yyyy)");
            checkOut = sdf.parse(sc.next());

            
            String error = reservation.updateDates(checkIn, checkOut);
            if (error!= null) {
                System.err.println("Error in reservation: " + error);
            } else {
            System.err.println("Reservation: " + reservation);
            }
           

        }


        sc.close();
    }
}
