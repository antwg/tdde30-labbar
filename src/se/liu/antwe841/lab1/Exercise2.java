package se.liu.antwe841.lab1;

import javax.swing.*;
import java.sql.SQLOutput;

public class Exercise2
{
    public static int sumFor(int min, int max) {
	int sum = 0;
	for(int i=min; i <= max; i++) {
	    sum += i;
	}
	return sum;
    }

    public static int sumWhile(int min, int max){
        int sum = 0;
        int i = min;
        while(i <= max){
            sum += i;
            i++;
	}
        return sum;
    }

    public static void main(String[] args) {
        final int min = 10;
        final int max = 20;
        String input = JOptionPane.showInputDialog("Enter either for or while!");
        switch(input) {
	    case "for":
		System.out.println(sumFor(min, max));
		break;
	    case "while":
		System.out.println(sumWhile(min, max));
		break;
	    default:
		System.out.println("Enter for of while");
	}
    }
}
