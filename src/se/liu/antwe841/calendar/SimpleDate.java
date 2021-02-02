package se.liu.antwe841.calendar;

public class SimpleDate
{
    private int year;
    private Month month;
    private int day;

    public SimpleDate(final int year, final Month month, final int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    public int getYear() {
	return year;
    }

    public Month getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }

    @Override public String toString() {
	return day + " " + month.getName() + " " + year;
    }

    public static void main(String[] args) {
        Month apr = new Month("april");
	SimpleDate test = new SimpleDate(2000, apr, 23);
	System.out.println(test);

    }
}
