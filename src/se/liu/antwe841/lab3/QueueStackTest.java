package se.liu.antwe841.lab3;

import se.liu.antwe841.lab1.Person;

import java.time.LocalDate;

public class QueueStackTest {
    public static void main(String[] args) {
	Stack stack = new Stack();

	Person anton = new Person("Anton", LocalDate.of(2000, 4, 23));
	Person disa = new Person("Disa", LocalDate.of(2000,9,10));
	Person axel = new Person("Axel", LocalDate.of(2000, 2,8));
	Person joy = new Person("Joy", LocalDate.of(2000, 2,9));
	Person rasmus = new Person("Rasmus", LocalDate.of(2000, 6,15));

	stack.push(anton);
	stack.push(disa);
	stack.push(axel);
	stack.push(joy);
	stack.push(rasmus);

	System.out.println(stack);
	while (!stack.isEmpty()) {
	    System.out.println(stack.pop());
	}

	System.out.println("\n");

	Queue queue = new Queue();

	queue.enqueue(anton);
	queue.enqueue(disa);
	queue.enqueue(axel);
	queue.enqueue(joy);
	queue.enqueue(rasmus);

	System.out.println(queue);
	while (!queue.isEmpty()){
	    System.out.println(queue.dequeue());
	}
    }

}
