package se.liu.antwe841.calendar;

public class TimePoint
{
    private int hour;
    private int minute;

    public TimePoint(final int hour, final int minute) {
	this.hour = hour;
	this.minute = minute;
    }

    public int getHour() {
	return hour;
    }

    public int getMinute() {
	return minute;
    }

    @Override public String toString() {
	return String.format("%02d:%02d", hour, minute);
    }

    public static void main(String[] args) {
	TimePoint test = new TimePoint(12, 15);
	System.out.println(test);
    }

}
