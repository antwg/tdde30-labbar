package se.liu.antwe841.calendar;

import java.util.ArrayList;
import java.util.List;

import static se.liu.antwe841.calendar.Month.getMonthDays;

public class Cal
{
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
	return appointments;
    }

    public Cal() {
	appointments = new ArrayList<>();
    }

    public static void main(String[] args) {
	Cal myCal = new Cal();
	myCal.book(2000, "april", 23, 7,5,8, 0, "Födas");
	myCal.book(2021, "january", 25, 10, 15, 12, 0, "Programmering");
	myCal.book(2021, "march", 18, 13, 30, 14, 35, "Skola");
	myCal.book(2003, "september", 14, 15, 15, 18, 20, "Chilla");
	myCal.book(2120, "june", 15, 18, 0, 19, 0 , "Chilla i graven");
	myCal.show();
    }

    public void show() {
	for (Appointment appointment : appointments) {
	    System.out.println(appointment);
	}
    }
    public void book(int year, String month, int day,
		     int startHour, int startMinute, int endHour,
		     int endMinute, String subject)
    {
        if (year < 1970) {
	    throw new IllegalArgumentException("Year argument too small");
	}
        if (startHour > 23 || startHour < 0 || endHour > 23 || endHour < 0) {
	    throw new IllegalArgumentException("Hour argument invalid");
	}
        if (startMinute > 60 || startMinute < 0 || endMinute > 60 || endMinute < 0) {
	    throw new IllegalArgumentException("Minute argument invalid");
	}
        switch (month) {
	    case "january":
	    case "february":
	    case "march":
	    case "april":
	    case "may":
	    case "june":
	    case "july":
	    case "august":
	    case "september":
	    case "october":
	    case "november":
	    case "december":
		break;
	    default:
		throw new IllegalArgumentException("Month argument invalid");
	}
        if (day <= 0 || day > getMonthDays(month)){
	    throw new IllegalArgumentException("Invalid day number for given month");
	}

        SimpleDate appDate = new SimpleDate(year, new Month(month), day);
        TimePoint appStartTime = new TimePoint(startHour, startMinute);
        TimePoint appEndTime = new TimePoint(endHour, endMinute);
        TimeSpan appTimeSpan = new TimeSpan(appStartTime, appEndTime);
        Appointment app = new Appointment(subject, appDate, appTimeSpan);
        appointments.add(app);
    }
}
