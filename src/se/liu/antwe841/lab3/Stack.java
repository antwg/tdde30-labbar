package se.liu.antwe841.lab3;

import se.liu.antwe841.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack extends ListManipulator {

    public void push(Person person){
        elements.add(0, person);
    }

    public Person pop(){
     	return elements.remove(0);
    }

    @Override public String toString() {
	return "Stack{" + "elements=" + elements + '}';
    }
}
