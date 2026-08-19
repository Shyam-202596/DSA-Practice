public class DigitSum {
    public static void main(String[] args) {
        // find sum of digits of given numbers using recursion.
		System.out.println(sumDigit(1234));
 
	}
	static int sumDigit(int n){
	    int rem = n % 10;
	    if(n % 10 == n){
	        return n;
	    }
	    return rem + sumDigit(n / 10);
    }
}
