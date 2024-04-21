public class MyDate {
    // Private instance variables
    private int year;
    private int month;
    private int day;

    // Static final variables
    public static final String[] MONTHS = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] DAY_IN_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Constructor
    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    // Static method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Static method to check if a date is valid
    public static boolean isValidDate(int year, int month, int day) {
        // Check if the year, month, and day are within valid ranges
        if (year < 1 || year > 9999 || month < 1 || month > 12)
            return false;
        
        // Determine the maximum number of days for the given month and year
        int maxDay = DAY_IN_MONTHS[month];
        // Adjust for February if it's a leap year
        if (month == 2 && isLeapYear(year))
            maxDay = 29;
        
        // Check if the day is within the valid range for the given month and year
        return day >= 1 && day <= maxDay;
    }

    // Static method to get the day of the week
    public static int getDayOfWeek(int year, int month, int day) {
        // Zeller's Congruence algorithm to determine the day of the week
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31*m0)/12) % 7;
        return d0;
    }

    // Setter methods
    public void setDate(int year, int month, int day) {
        // Check if the provided date is valid
        if (!isValidDate(year, month, day))
            throw new IllegalArgumentException("Invalid year, month, or day!");
        // Set the instance variables
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setYear(int year) {
        // Check if the provided year is valid
        if (year < 1 || year > 9999)
            throw new IllegalArgumentException("Invalid year!");
        this.year = year;
    }

    public void setMonth(int month) {
        // Check if the provided month is valid
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month!");
        this.month = month;
    }

    public void setDay(int day) {
        // Determine the maximum number of days for the given month and year
        int maxDay = DAY_IN_MONTHS[month];
        // Adjust for February if it's a leap year
        if (month == 2 && isLeapYear(year))
            maxDay = 29;
        // Check if the provided day is valid
        if (day < 1 || day > maxDay)
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

    // toString method to format the date as required
    @Override
    public String toString() {
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month] + " " + year;
    }

    // Utility method to increment day by 1
    private void incrementDay() {
        // Determine the maximum number of days for the given month and year
        int maxDay = DAY_IN_MONTHS[month];
        // Adjust for February if it's a leap year
        if (month == 2 && isLeapYear(year))
            maxDay = 29;
        // Increment the day by 1
        if (day < maxDay)
            day++;
        else {
            // If it's the last day of the month, reset day to 1 and increment month
            day = 1;
            incrementMonth();
        }
    }

    // Utility method to increment month by 1
    private void incrementMonth() {
        if (month < 12)
            month++;
        else {
            // If it's December, reset month to January and increment year
            month = 1;
            year++;
        }
    }

    // Utility method to increment year by 1
    private void incrementYear() {
        year++;
    }

    // Utility method to decrement day by 1
    private void decrementDay() {
        if (day > 1)
            day--;
        else {
            // If it's the first day of the month, reset day to the last day of the previous month
            decrementMonth();
            day = DAY_IN_MONTHS[month];
            // Adjust for February if it's a leap year
            if (month == 2 && isLeapYear(year))
                day = 29;
        }
    }

    // Utility method to decrement month by 1
    private void decrementMonth() {
        if (month > 1)
            month--;
        else {
            // If it's January, reset month to December and decrement year
            month = 12;
            year--;
        }
    }

    // Utility method to decrement year by 1
    private void decrementYear() {
        year--;
    }

    // Methods to get next and previous dates
    public MyDate nextDay() {
        incrementDay();
        return this;
    }

    public MyDate nextMonth() {
        incrementMonth();
        // If the day exceeds the maximum day of the new month, reset it to the maximum day
        if (day > DAY_IN_MONTHS[month]) {
            day = DAY_IN_MONTHS[month];
            // Adjust for February if it's a leap year
            if (month == 2 && isLeapYear(year))
                day = 29;
        }
        return this;
    }

    public MyDate nextYear() {
        incrementYear();
        // If the current date is February 29th and the next year is not a leap year, reset day to 28th
        if (day == 29 && month == 2 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public MyDate previousDay() {
        decrementDay();
        return this;
    }

    public MyDate previousMonth() {
        decrementMonth();
        // If the day exceeds the maximum day of the new month, reset it to the maximum day
        if (day > DAY_IN_MONTHS[month]) {
            day = DAY_IN_MONTHS[month];
            // Adjust for February if it's a leap year
            if (month == 2 && isLeapYear(year))
                day = 29;
        }
        return this;
    }

    public MyDate previousYear() {
        decrementYear();
        // If the current date is February 29th and the previous year is not a leap year, reset day to 28th
        if (day == 29 && month == 2 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }
}
