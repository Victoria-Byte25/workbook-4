package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    // Moved this up so no red warnings show
    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public void checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true;
            System.out.println("Guest checked in. Room now occupied and dirty.");
        } else {
            System.out.println("Room not available for check-in.");
        }
    }

    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Guest checked out. Room is now unoccupied and dirty.");
        } else {
            System.out.println("Room is already unoccupied.");
        }
    }

    public void cleanRoom() {
        if (!isOccupied && isDirty) {
            isDirty = false;
            System.out.println("Room has been cleaned and is now available.");
        } else {
            System.out.println("Room cannot be cleaned right now.");
        }
    }
}
