

// Fruit class represents a generic fruit with a name and a code.
class Fruit {
    private int code;
    private String name;
    static int counter = 1000;

    Fruit(String name) {
        this.name = name;
    }
} //end class Fruit

// Fruitingms class represents fruits sold by kilograms.
class Fruitingms extends Fruit {
    private double available_kgs; // Available kilograms of the fruit.
    private double price_per_kg; // Price per kilogram of the fruit.

    // Constructor for Fruitingms class.
    Fruitingms(String name, double available_kgs, double price_per_kg) {
        super(name);
        this.available_kgs = available_kgs;
        this.price_per_kg = price_per_kg;
    }

    // Method to get the price per kilogram.
    public double getprice() {

        return price_per_kg;
    }

    // Method to check if required kilograms of fruit are available.
    public boolean checkavailability(double need) {
        //write your code here
        return available_kgs >= need;
    }

    // Method to update available kilograms of fruit after sale.
    public void updateavailability(double need) {
        //write your code here
        available_kgs -= need;
    }
} //end class Fruitinms

// Fruitinpcs class represents fruits sold by pieces.
class Fruitinpcs extends Fruit {
    private double available_pcs; // Available pieces of the fruit.
    private double price_per_piece; // Price per piece of the fruit.

    // Constructor of Fruitinpcs class.
    Fruitinpcs(String name, double available_pcs, double price_per_piece) {

        super(name);
        this.available_pcs = available_pcs;
        this.price_per_piece = price_per_piece;
    }

    // Method to get the price per piece.
    public double getPrice() {
        return price_per_piece;
    }

    // Method to check if required pieces of fruit are available.
    public boolean checkavailability(double need) {
        //write your code here
        return available_pcs >= need;
    }

    // Method to update available pieces of fruit after sale.
    public void updateavailability(double need) {
        available_pcs = available_pcs - need;
    }
} //end class Fruitinpcs

// Sale class represents a sale of fruit.
class Sale {
    private int code; 
    private Fruit fobj; // Fruit object being sold.
    private double unit; // Quantity of fruit being sold.
    private double amount; // Total amount for the sale.
    static int counter = 2000;

    // Constructor for Sale class.
    Sale(Fruit fobj, double unit) {
        this.fobj = fobj;
        this.unit = unit;
    }

    // Method to calculate the bill for the sale.
    public double bill() {
        //write your code here
        if(fobj instanceof Fruitingms) {
            Fruitingms fruit = (Fruitingms) fobj;
            if (!fruit.checkavailability(unit)) {
                System.out.println("Item not available");
                return -1;
            }else{
                amount = fruit.getprice() * unit;
                fruit.updateavailability(unit);
            }
        }else if(fobj instanceof Fruitinpcs) {
            Fruitinpcs fruit = (Fruitinpcs) fobj;
            if (!fruit.checkavailability(unit)) {
                System.out.println("Item not available");
                return -1;
            }else {
                amount = fruit.getPrice() * unit;
                fruit.updateavailability(unit);
            }
        }

        // Apply discount if the amount exceeds 1500.
        if (amount > 1500) {
            amount = discount();
        }
        return amount;
    }

    // Method to calculate discount.
    public double discount() {
        double disc = (amount / 100) * 5;
        amount = amount - disc;
        return amount;
    }
}//end class Sale

// Demo class to demonstrate the functionality of the billing system.
class Demo {
    public static void main(String args[]) {
        Fruit fobj = new Fruitingms("apple", 50.6, 80.0);
        Sale s = new Sale(fobj, 2.0);
        System.out.println(s.bill());
        Fruit fobj1 = new Fruitinpcs("banana", 200, 3.0);
        Sale s1 = new Sale(fobj1, 10);
        System.out.println(s1.bill());
    }
}