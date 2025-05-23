package com.pluralsight;

public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        if (!roomType.equalsIgnoreCase("king") && !roomType.equalsIgnoreCase("double")) {
            throw new IllegalArgumentException("Room type must be 'king' or 'double'");
        }

        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        if (!roomType.equalsIgnoreCase("king") && !roomType.equalsIgnoreCase("double")) {
            throw new IllegalArgumentException("Room type must be 'king' or 'double'");
        }
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getPrice() {
        double basePrice = roomType.equalsIgnoreCase("king") ? 139.00 : 124.00;
        if (isWeekend) {
            basePrice *= 1.10;
        }
        return basePrice;
    }

    public double getReservationTotal() {
        return getPrice() * numberOfNights;
    }
}



