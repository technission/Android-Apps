package com.example.testapplication;

public class House {
    int temperature;
    String flooring;
    String cityOfHouse;
    int numTables;

    public void checkTemp() {
        if(temperature > 70) {
            System.out.println("That's a high temp turn on the AC!");
        } else {
            System.out.println("Increase your temp!");
        }

    }
    public House(int temperature, String flooring, String cityOfHouse, int numTables) {
        this.temperature = temperature;
        this.flooring = flooring;
        this.cityOfHouse = cityOfHouse;
        this.numTables = numTables;
    }
}
