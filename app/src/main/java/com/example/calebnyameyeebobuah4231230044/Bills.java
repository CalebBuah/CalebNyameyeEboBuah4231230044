package com.example.calebnyameyeebobuah4231230044;

public class Bills {

    private double gallons;
    private double kilowatts;

    public Bills(double gallons, double kilowatts) {
        this.gallons = gallons;
        this.kilowatts = kilowatts;
    }

    public double getGallons() {
        return gallons;
    }

    public double getKilowatts() {
        return kilowatts;
    }

    public double waterBill() {
        if (gallons <= 500) {
            return 0.0;
        } else {
            return (gallons - 500) * 1.05;
        }
    }
}
