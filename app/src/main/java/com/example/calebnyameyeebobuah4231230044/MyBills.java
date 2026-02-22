package com.example.calebnyameyeebobuah4231230044;

public class MyBills extends Bills {

    public MyBills() {
        super(0, 0);
    }

    public MyBills(double gallons, double kilowatts) {
        super(gallons, kilowatts);
    }

    public double electricityBill() {
        double units = getKilowatts();
        double bill;

        if (units <= 50) {
            bill = 0.0;
        } else if (units <= 150) {
            bill = (units - 50) * 0.50;
        } else {
            bill = (100 * 0.50) + ((units - 150) * 1.20);
        }

        return bill;
    }

    public double totalBill() {
        return waterBill() + electricityBill();
    }
}

