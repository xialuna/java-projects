package SingleInheritance;
// Parent class
public class Vehicle {
    protected String brand; // Brand of the vehicle
    protected int year; // Year of manufacture
    
    // Constructor for Vehicle class
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    
    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}