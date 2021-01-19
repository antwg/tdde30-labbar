package se.liu.antwe841.lab1;

public class Exercise6
{
    public static boolean isPrime(int number){
        int out = 0;
        for(int i = 2; i < number - 1; i++){
	    int rest = number % i;
	    if (rest == 0) {
		// number är en jämn multipel av i
		out += 1;
	    }
	}
        if (out > 0) {
	    return false;
	}
        else{
            return true;
	}
    }

    public static void main(String[] args) {
	System.out.println(isPrime(5039));

    }
}
/* Uppgift Påbörja avlusning */