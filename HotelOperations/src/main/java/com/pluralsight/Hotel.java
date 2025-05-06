package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor 1 – assume nothing is booked
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    // Constructor 2 – allows setting booked values
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    // Booking method
    public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite) {
        if (isSuite) {
            if (numberOfRoomsToBook <= getAvailableSuites()) {
                bookedSuites += numberOfRoomsToBook;
                System.out.println("Successfully booked " + numberOfRoomsToBook + " suite(s).");
                return true;
            }
        } else {
            if (numberOfRoomsToBook <= getAvailableRooms()) {
                bookedBasicRooms += numberOfRoomsToBook;
                System.out.println("Successfully booked " + numberOfRoomsToBook + " basic room(s).");
                return true;
            }
        }
        System.out.println("Not enough rooms available.");
        return false;
    }

    // Derived getters (no private vars backing these!)
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }
}

