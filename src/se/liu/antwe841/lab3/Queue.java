package se.liu.antwe841.lab3;

import se.liu.antwe841.lab1.Person;

public class Queue extends ListManipulator {

    public void enqueue(Person person){
        add(person);
    }

    public Person dequeue(){
     	return elements.remove(0);
    } //kan ta bort elements

    @Override public String toString() {
	return "Queue{" + "elements=" + elements + '}';
    }
}
