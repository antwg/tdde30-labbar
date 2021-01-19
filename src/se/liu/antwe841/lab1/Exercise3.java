package se.liu.antwe841.lab1;

import javax.swing.*;

public class Exercise3
{

    private final static int TABELL = 5;

    public static void main(String[] args) {
	String input = JOptionPane.showInputDialog("Please input a value");
	int tabell = Integer.parseInt(input);
        int i = 0;
        while(i <= 10){
	    System.out.println(i + "*" + tabell + "=" + i * tabell);
	    i++;
	}
    }
}
