package se.liu.antwe841.lab1;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private String name;
    private LocalDate birthDay;

    public Person(String name, LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }
    public int getAge() {
	return Period.between(birthDay, LocalDate.now()).getYears();
    }

    @Override public String toString() {
	return name + " " + getAge();
    }

    public static void main(String[] args) {
	Person anton = new Person("Anton", LocalDate.of(2000,4,23));
	Person disa = new Person("Disa", LocalDate.of(2000,9,10));
	Person axel = new Person("Axel", LocalDate.of(2000, 2,8));

	System.out.println(anton);
	System.out.println(disa);
	System.out.println(axel);
    }

}
