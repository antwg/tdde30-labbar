package se.liu.antwe841.lab1;

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
	System.out.println(sumWhile(min, max));

    }

}
