package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double lastPunchInTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.lastPunchInTime = 0.0;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // Manual Punch In
    public void punchIn(double time) {
        lastPunchInTime = time;
        System.out.println(name + " punched in at " + time);
    }

    // Manual Punch Out
    public void punchOut(double time) {
        if (lastPunchInTime == 0) {
            System.out.println("Error: must punch in first.");
        } else {
            double worked = time - lastPunchInTime;
            hoursWorked += worked;
            System.out.println(name + " punched out at " + time + " (worked: " + worked + " hrs)");
            lastPunchInTime = 0;
        }
    }

    // Overloaded Punch In
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        lastPunchInTime = now.getHour() + (now.getMinute() / 60.0);
        System.out.println(name + " auto-punched in at " + now.getHour() + ":" + now.getMinute());
    }

    // Overloaded Punch Out
    public void punchOut() {
        if (lastPunchInTime == 0) {
            System.out.println("Error: must punch in first.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            double punchOutTime = now.getHour() + (now.getMinute() / 60.0);
            double worked = punchOutTime - lastPunchInTime;
            hoursWorked += worked;
            System.out.println(name + " auto-punched out at " + now.getHour() + ":" + now.getMinute()
                    + " (worked: " + worked + " hrs)");
            lastPunchInTime = 0;
        }
    }
}
