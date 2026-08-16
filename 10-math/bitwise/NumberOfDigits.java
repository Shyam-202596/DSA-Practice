public class NumberOfDigits {
    public static void main(String[] args) {
        int n = 31;
		int ans = numberOfDigit(n);
		System.out.println(ans);
    }
    //code to find Number of digits in in base b.
    static int numberOfDigit(int n){
	    int b = 2;
	    int digits = (int)(Math.log(n)/Math.log(b)) + 1;
	    return digits;
	}
}
