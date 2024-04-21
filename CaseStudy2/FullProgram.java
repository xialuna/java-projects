import java.util.Scanner;
public class FullProgram {
    
    static class MyDate{
        // Private instance variables
        private int year, month, day;
            
        // Constructor for MyDate
        MyDate(int year, int month, int day){
            setDate(year, month, day);
        }

        public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        public static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Method to check if a year is a leap year
        public static boolean isLeapYear(int year){
            return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)); // returns true or false              
        } 

        //ethod to check if a date is valid
        public static boolean isValidDate(int year, int month, int day){ 
            // Check if the year and month are within valid ranges
            if (year < 1 || year > 9999 || month < 1 || month > 12)
                return false;
            
            // Adjust February's day if it's leap year
            if (month == 2 && isLeapYear(year))
                DAYS_IN_MONTHS[month] = 29;
            
            // Check if the day is within the valid range for the given month and year
            return day >= 1 && day <= DAYS_IN_MONTHS[month]; //returns true / false
        } 

        public static int getDayOfWeek(int year, int month, int day){
            if (month == 1){    // for January
                month = 13;
                year--;
            } else if (month == 2){ // for February
                month = 14;
                year--;
            }

            // get the value of the day of the week using ZELLER'S CONGRUENCE
            int q = day;
            int m = month;
            int k = year % 100;
            int j = year / 100;
            int h = q + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
            h = h % 7;

            if (h == 0){    // goes back to the end of DAYS[] since counting starts from 1
                return DAYS.length-1;
            } else {
                return h-1;
            }
                
        }

        public void setDate(int year, int month, int day){   
            // Check if the date is valid         
            if (!isValidDate(year, month, day)){
                throw new IllegalArgumentException("Invalid year, month, or day!");
            } 
            // Set the instance variables
            this.year = year;
            this.month = month;
            this.day = day;
            }

        public void setYear(int year){
            // Check if the year is valid
            if (year >= 1 && year <= 9999){
                this.year = year;                
            } else {
                    throw new IllegalArgumentException("Invalid year!");
            }
        }

        public void setMonth(int month){
            //Check if the month is valid
            if (month >= 1 && month <= 12){
                this.month = month;
            } else {
                throw new IllegalArgumentException("Invalid month!");
            }
        }

        public void setDay(int day){
            // Determine the month and year's maximum number of days
            int dayMax =  DAYS_IN_MONTHS[month];
            // Adjust for February if it's a leap year
            if (month == 2 && isLeapYear(year))
                dayMax = 29;
            // Check if the provided day is valid
            if (day < 1 || day > dayMax)
                throw new IllegalArgumentException("Invalid day!");
            this.day = day;
        }

    // Getter methods
        public int getYear(){
            return year;
        }

        public int getMonth(){
            return month;
        }

        public int getDay(){
            return day;
        }
        // method to format the date as specified
        public String toString(){
            int dayWeek = getDayOfWeek(getYear(),getMonth(),getDay());
            return String.format("%s %d %s %d", DAYS[dayWeek], getDay(), MONTHS[getMonth()-1], getYear());
        }

        public MyDate nextDay(){
            this.day += 1;
            if (isLeapYear(year) == true){
                DAYS_IN_MONTHS[1] = 29;
            }

            // Increment the day by 1 if its the last day of that month
            if (day > DAYS_IN_MONTHS[getMonth()-1]){   
                day = 1;        // set it to 1 since it's the start of all months
                nextMonth();    // checks and adds to month value
            }
            return this;
        }

        public MyDate nextMonth(){
            this.month += 1;
            if (getMonth() >= 12){  // for decembers
                this.month = 1;
                year += 1;
            }             
            return this;
        }

        public MyDate nextYear(){
            this.year += 1;
            if (year > 9999){
                throw new IllegalArgumentException("Year out of range!");
            }
            return this;
        }

        public MyDate previousDay(){
            this.day -= 1;
            if (day < 1){   // if day is slready at 1
                this.day = DAYS_IN_MONTHS[getMonth()-1]; // gives value of last day to this.day
                previousMonth();    // checks and adds to month value
                if (getMonth() == MONTHS.length){
                    previousYear();
                } // if end
            } // if end
            return this;
        }

        public MyDate previousMonth(){
            this.month -= 1;
            if (this.month == 0){
                this.month = MONTHS.length;
            }
            if (getDay() > DAYS_IN_MONTHS[getMonth()-1]){
                this.day = DAYS_IN_MONTHS[getMonth()-1];
            }
                return this;
        }

        public MyDate previousYear(){
            this.year -= 1;
            if (isLeapYear(year) == false && getMonth() == 2){
                DAYS_IN_MONTHS[getMonth()-1] = 28;                
                this.day = DAYS_IN_MONTHS[getMonth()-1];
            }
            return this;
        }
    } // public class end

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("[1] Print out test program\n[2] Print out each day from 28 Dec 2011 to 2 Mar 2012\n>> ");
        int option = scan.nextInt();

        switch (option) {
            case 1:
                MyDate d1 = new MyDate(2012,2,28);

                System.out.println(d1);
                System.out.println(d1.nextDay());
                System.out.println(d1.nextDay());
                System.out.println(d1.nextMonth());
                System.out.println(d1.nextYear());
                System.out.println();

                MyDate d2 = new MyDate(2012, 1, 2);
                System.out.println(d2);
                System.out.println(d2.previousDay());
                System.out.println(d2.previousDay());
                System.out.println(d2.previousMonth());
                System.out.println(d2.previousYear());
                System.out.println();

                MyDate d3 = new MyDate(2012, 2, 29);
                System.out.println(d3.previousYear());
                break;
            case 2:
                MyDate test = new MyDate(2011, 12, 28);
                System.out.println(test);
                while (!(test.getYear() == 2012 && test.getMonth() == 3 && test.getDay() == 2)){
                    System.out.println(test.nextDay());
                }
                break;
            default:
                System.out.println("Invalid Input");
                break;
        } 
        scan.close();
    } 
}
