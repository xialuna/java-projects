/**
 * @author GROUP #
 * Members:
 * - Cheng, Xian
 * - Pascual, Ian Nevri
 * - Quinto, Raven Luke
 * 
 * CASE STUDY 2: MyDate Class 
 */

public class MyDate{
    // Private instance variables
    private int year, month, day;
        
    // constructor for MyDate
    MyDate(int year, int month, int day){
        setDate(year, month, day);
    }

    public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static boolean isLeapYear(int year){
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){                
            DAYS_IN_MONTHS[1] = 29;
            return true;
        } // if end
        return false;
    } // isLeapYear end

    public static boolean isValidDate(int year, int month, int day){ 
        if (year <=9999 && year >= 1){
            if (month <= 12 && month >= 1){
                if (day >= 1 && day <= DAYS_IN_MONTHS[month-1]){
                    return true;
                } // if end
            } // if end
        } // if end
        return false;
    } // isValidDate end

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
        if (isValidDate(year, month, day) == true){
            setYear(year);
            setMonth(month);
            setDay(day);
        } else {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        //toString(); // prints date if object is printed
        }

    public void setYear(int year){
        if (year >= 1 && year <= 9999){
            this.year = year;                
        } else {
                throw new IllegalArgumentException("Invalid year!");
        }
    }

    public void setMonth(int month){
        if (month >= 1 && month <= 12){
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month!");
        }
    }

    public void setDay(int day){
        int dayMax = 0;
        dayMax = DAYS_IN_MONTHS[getMonth()-1];
        if (isLeapYear(getYear()) == true && day <= dayMax){
            this.day = day;
        } else if (day <= dayMax) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day!");
        }   
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String toString(){
        int dayWeek = getDayOfWeek(getYear(),getMonth(),getDay());
        return String.format("%s %d %s %d", DAYS[dayWeek], getDay(), MONTHS[getMonth()-1], getYear());
    }

    public String nextDay(){
        this.day += 1;
        if (isLeapYear(year) == true){
            DAYS_IN_MONTHS[1] = 29;
        }
        if (day > DAYS_IN_MONTHS[getMonth()-1]){   // if its the last day of that month
            day = 1;        // 1 since it's the start of all months
            nextMonth();    // checks and adds to month value
        }
        return toString();
    }

    public String nextMonth(){
        this.month += 1;
        if (getMonth() >= 12){  // for decembers
            this.month = 1;
             year += 1;
        }
        // if (getDay() == DAYS_IN_MONTHS[getMonth()-1]){  
        //     day = DAYS_IN_MONTHS[getMonth()-1];        
        // }
            
        return toString();
    }

    public String nextYear(){
        this.year += 1;
        if (year > 9999){
            throw new IllegalArgumentException("Year out of range!");
        }
        return toString();
    }

    public String previousDay(){
        this.day -= 1;
        if (day < 1){   // if day is slready at 1
            this.day = DAYS_IN_MONTHS[getMonth()-1]; // gives value of last day to this.day
            previousMonth();    // checks and adds to month value
            if (getMonth() == MONTHS.length){
                previousYear();
            } // if end
        } // if end
        return toString();
    }

    public String previousMonth(){
        this.month -= 1;
        if (this.month == 0){
            this.month = MONTHS.length;
        }
        if (getDay() > DAYS_IN_MONTHS[getMonth()-1]){
            this.day = DAYS_IN_MONTHS[getMonth()-1];
        }
            return toString();
    }

    public String previousYear(){
        this.year -= 1;
        if (isLeapYear(year) == false && getMonth() == 2){
            DAYS_IN_MONTHS[getMonth()-1] = 28;                
            this.day = DAYS_IN_MONTHS[getMonth()-1];
        }
        return toString();
    }
} // public class end