package SingleInheritance;


// Child class inheriting from Vehicle class
class Car extends Vehicle {
    private int numberOfDoors; // Number of doors of the car
    
    // Constructor for Car class
    public Car(String brand, int year, int numberOfDoors) {
        // Calling superclass constructor
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }
    
    // Method to display car information
    public void displayCarInfo() {
        // Accessing superclass method
        displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }
}

