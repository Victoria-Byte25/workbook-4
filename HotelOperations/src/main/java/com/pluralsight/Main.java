package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Room Input ---
        System.out.print("How many beds in the room? ");
        int beds = scanner.nextInt();

        System.out.print("Enter room price: ");
        double price = scanner.nextDouble();

        System.out.print("Is the room occupied? (true/false): ");
        boolean isOccupied = scanner.nextBoolean();

        System.out.print("Is the room dirty? (true/false): ");
        boolean isDirty = scanner.nextBoolean();

        Room room = new Room(beds, price, isOccupied, isDirty);

        System.out.println("\nChecking availability... ");
        if (room.isAvailable()) {
            System.out.println("Yup! Room is available. Book it, babe. ");
        } else {
            System.out.println("Nope. This room is not ready. Next! ");
        }

        // --- Reservation Test ---
        Reservation reservation = new Reservation("king", 2, true);
        System.out.println("\n--- Reservation Details ---");
        System.out.println("Room Type: " + reservation.getRoomType());
        System.out.println("Nights: " + reservation.getNumberOfNights());
        System.out.println("Weekend? " + reservation.isWeekend());
        System.out.println("Nightly Price: $" + reservation.getPrice());
        System.out.println("Total: $" + reservation.getReservationTotal());

        // --- Employee Test ---
        Employee emp = new Employee("D501", "Dave Brown", "Housekeeping", 20.00, 45);

        System.out.println("\n--- Employee Payroll Info ---");
        System.out.println("Employee ID: " + emp.getEmployeeId());
        System.out.println("Name: " + emp.getName());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Regular Hours: " + emp.getRegularHours());
        System.out.println("Overtime Hours: " + emp.getOvertimeHours());
        System.out.println("Total Pay: $" + emp.getTotalPay());

        scanner.close();
    }
}



