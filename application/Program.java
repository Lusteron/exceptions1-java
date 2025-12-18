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

            Date now = new Date();
            if (checkIn.before(now)|| checkOut.before(now)) {
                System.err.println("Error in reservation: Reservation dates for update must be future");
            } else if (!checkOut.after(checkIn)){
                System.err.println("Error int reservatioon: Check-out date must be after check in date");

            } else {
                reservation.updateDates(checkIn, checkOut);
                System.err.println("Reservation: " + reservation);
            }
           

        }


        sc.close();
    }
}
