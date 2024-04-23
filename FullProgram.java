import java.util.Scanner;

public class FullProgram {

    static class MyDate {
        // Private instance variables
        private int year, month, day;

        // Constructor for MyDate
        MyDate(int year, int month, int day) {
            setDate(year, month, day);
        }

        // Static final variables
        public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        public static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Method to check if a year is a leap year
        public static boolean isLeapYear(int year) {
            return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)); // returns true or false
        }

        // Method to check if a date is valid
        public static boolean isValidDate(int year, int month, int day) {
            // Check if the year and month are within valid ranges
            if (year < 1 || year > 9999 || month < 1 || month > 12)
                return false;

            // Adjust February's day if it's a leap year
            if (month == 2 && isLeapYear(year))
                return day >= 1 && day <= 29;
            else
                return day >= 1 && day <= DAYS_IN_MONTHS[month - 1]; // returns true / false
        }

        // Method to get the day of the week
        public static int getDayOfWeek(int year, int month, int day) {
            if (month == 1) {    // for January
                month = 13;
                year--;
            } else if (month == 2) { // for February
                month = 14;
                year--;
            }

            // get the value of the day of the week using ZELLER'S CONGRUENCE
            int q = day;
            int m = month;
            int k = year % 100;
            int j = year / 100;
            int h = q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
            h = h % 7;

            if (h == 0) {    // goes back to the end of DAYS[] since counting starts from 1
                return DAYS.length - 1;
            } else {
                return h - 1;
            }
        }

        public void setDate(int year, int month, int day) {
            // Check if the date is valid
            if (!isValidDate(year, month, day)) {
                throw new IllegalArgumentException("Invalid year, month, or day!");
            }
            // Set the instance variables
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public void setYear(int year) {
            // Check if the year is valid
            if (year >= 1 && year <= 9999) {
                this.year = year;
            } else {
                throw new IllegalArgumentException("Invalid year!");
            }
        }

        public void setMonth(int month) {
            //Check if the month is valid
            if (month >= 1 && month <= 12) {
                this.month = month;
            } else {
                throw new IllegalArgumentException("Invalid month!");
            }
        }

        public void setDay(int day) {
            // Determine the month and year's maximum number of days
            int dayMax = DAYS_IN_MONTHS[month - 1];
            // Adjust for February if it's a leap year
            if (month == 2 && isLeapYear(year))
                dayMax = 29;
            // Check if the provided day is valid
            if (day < 1 || day > dayMax)
                throw new IllegalArgumentException("Invalid day!");
            this.day = day;
        }

        // Getter methods
        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        // Method to format the date as specified
        public String toString() {
            int dayWeek = getDayOfWeek(getYear(), getMonth(), getDay());
            return String.format("%s %d %s %d", DAYS[dayWeek], getDay(), MONTHS[getMonth() - 1], getYear());
        }

        // Method to get the next day
        public MyDate nextDay() {
            this.day += 1;

            // Adjust February's day if it's a leap year
            if (getMonth() == 2 && isLeapYear(year)) {
                if (this.day > 29) {
                    this.day = 1;
                    nextMonth();
                }
            } else if (this.day > DAYS_IN_MONTHS[getMonth() - 1]) {   // Increment the day by 1 if it's the last day of the month
                this.day = 1;
                nextMonth();
            }
            return this;
        }

        // Method to get the next month
        public MyDate nextMonth() {
            this.month += 1;
            if (this.month > 12) {  // for December
                this.month = 1;
                nextYear();
            }
            return this;
        }

        // Method to get the next year
        public MyDate nextYear() {
            this.year += 1;
            if (year > 9999) {
                throw new IllegalArgumentException("Year out of range!");
            }
            return this;
        }

        // Method to get the previous day
        public MyDate previousDay() {
            this.day -= 1;
            if (this.day < 1) {   // If day is already at 1
                previousMonth();    // Decrement the month value
                this.day = DAYS_IN_MONTHS[getMonth() - 1]; // Give value of last day to this.day
            }
            return this;
        }

        // Method to get the previous month
        public MyDate previousMonth() {
            this.month -= 1;
            if (this.month == 0) {
                this.month = 12;
                previousYear();
            }
            if (this.day > DAYS_IN_MONTHS[getMonth() - 1]) {
                this.day = DAYS_IN_MONTHS[getMonth() - 1];
            }
            return this;
        }

        // Method to get the previous year
        public MyDate previousYear() {
            this.year -= 1;
            if (!isLeapYear(year) && getMonth() == 2 && getDay() == 29) {
                this.day = 28;
            }
            return this;
        }
    } 

}
