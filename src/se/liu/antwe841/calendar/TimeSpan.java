package se.liu.antwe841.calendar;

public class TimeSpan
{
    private TimePoint start;
    private TimePoint end;

    public TimeSpan(final TimePoint start, final TimePoint end) {
	this.start = start;
	this.end = end;
    }

    public TimePoint getStart() {
	return start;
    }

    public TimePoint getEnd() {
	return end;
    }

    @Override public String toString() {
	return String.format("%s-%s", start, end);
    }

    public static void main(String[] args) {
	TimePoint str = new TimePoint(12, 15);
	TimePoint nd = new TimePoint(13, 15);
	TimeSpan ts = new TimeSpan(str, nd);
	System.out.println(ts);
    }
}
