package com.pluralsight;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- ROOM TEST ---
        System.out.print("How many beds in the room? ");
        int beds = scanner.nextInt();

        System.out.print("Enter room price: ");
        double price = scanner.nextDouble();

        System.out.print("Is the room occupied? (true/false): ");
        boolean isOccupied = scanner.nextBoolean();

        System.out.print("Is the room dirty? (true/false): ");
        boolean isDirty = scanner.nextBoolean();

        Room room = new Room(beds, price, isOccupied, isDirty);

        System.out.println("\nChecking availability...");
        if (room.isAvailable()) {
            System.out.println("Yup! Room is available. Book it, babe.");
        } else {
            System.out.println("Nope. This room is not ready. Next!");
        }

        System.out.println("\n>> ROOM CHECK-IN PROCESS");
        room.checkIn();
        room.checkOut();
        room.cleanRoom();

        // --- RESERVATION TEST ---
        Reservation reservation = new Reservation("king", 2, true);
        System.out.println("\n--- Reservation Details ---");
        System.out.println("Room Type: " + reservation.getRoomType());
        System.out.println("Nights: " + reservation.getNumberOfNights());
        System.out.println("Weekend? " + reservation.isWeekend());
        System.out.println("Nightly Price: $" + reservation.getPrice());
        System.out.println("Total: $" + reservation.getReservationTotal());

        // --- EMPLOYEE TEST (Manual) ---
        Employee emp1 = new Employee("E001", "Naade", "Housekeeping", 35.00, 0.0);
        System.out.println("\n>> MANUAL TIME CLOCK");
        emp1.punchIn(9.0);   // 9:00 AM
        emp1.punchOut(18.0); // 6:00 PM

        System.out.println("Regular hours: " + emp1.getRegularHours());
        System.out.println("Overtime hours: " + emp1.getOvertimeHours());
        System.out.println("Total Pay: $" + emp1.getTotalPay());

        // --- EMPLOYEE TEST (Auto) ---
        Employee emp2 = new Employee("DA560", "Lola", "Front Desk", 30.00, 0.0);
        System.out.println("\n>> AUTO TIME CLOCK");

        emp2.punchIn();  // uses system time
        try {
            Thread.sleep(3000);  // simulate working for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        emp2.punchOut(); // uses system time

        System.out.println("Auto Regular hours: " + emp2.getRegularHours());
        System.out.println("Auto Total Pay: $" + emp2.getTotalPay());

        // --- HOTEL CLASS TEST ---
        System.out.println("\nHOTEL BOOKING SYSTEM TEST");

        Hotel myHotel = new Hotel("The Sweet Stay", 5, 10); // 5 suites, 10 rooms

        System.out.println("Available Suites: " + myHotel.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + myHotel.getAvailableRooms());

        boolean bookedSuites = myHotel.bookRoom(2, true);
        System.out.println("Booking 2 suites: " + (bookedSuites ? "Success" : "Failed"));

        boolean bookedBasics = myHotel.bookRoom(3, false);
        System.out.println("Booking 3 basic rooms: " + (bookedBasics ? "Success" : "Failed"));

        boolean overbookAttempt = myHotel.bookRoom(10, true);
        System.out.println("Booking 10 suites: " + (overbookAttempt ? "Success" : "Failed"));

        System.out.println("Remaining Suites: " + myHotel.getAvailableSuites());
        System.out.println("Remaining Basic Rooms: " + myHotel.getAvailableRooms());

        scanner.close();
    }
}




