package se.liu.antwe841.calendar;

public class Month
{
    private String name;
    private int number;
    private int days;

    public Month(final String name) {
	this.name = name;
	this.number = getMonthNumber(name);
	this.days = getMonthDays(name);
    }

    public String getName() {
	return name;
    }

    public int getNumber() {
	return number;
    }

    public int getDays() {
	return days;
    }

    public static void main(String[] args) {
        String d = "april";
        System.out.println("Month nr: " + getMonthNumber(d) + " " + "Month days: " +getMonthDays(d));
	}

    public static int getMonthNumber(String name){
        switch (name){
	    case "january":
	        return 1;
	    case "february":
	        return 2;
	    case "march":
	    	return 3;
	    case "april":
		return 4;
	    case "may":
		return 5;
	    case "june":
		return 6;
	    case "july":
		return 7;
	    case "august":
		return 8;
	    case "september":
		return 9;
	    case "october":
		return 10;
	    case "november":
		return 11;
	    case "december":
		return 12;
	    default:
	        return -1;
	}
    }
    public static int getMonthDays(String name){
	switch (name){
	    case "january":
	    case "march":
	    case "may":
	    case "july":
	    case "august":
	    case "october":
	    case "decemer":
	        return 31;
	    case "april":
	    case "june":
	    case "september":
	    case "november":
	        return 30;
	    case "february":
	        return 28;
	    default:
	        return -1;
	}
    }
}
