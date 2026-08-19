public class Palindrome {
    public static void main(String[] args) {
        // check Palindrome.
		System.out.println(isPalindrome(12321));
 
	}
	static boolean isPalindrome(int n){
	    return n == rev1(n);
	}
	static int rev1(int n){
	    int rev = 0;
	    while(n > 0){
	        int rem = n % 10;
	        rev = rev * 10 + rem;
	        n = n /10;
	    }
	    return rev;
	}
	static int rev2(int n){
	    if(n % 10 == n){
	        return n;
	    }
	    int rem = n % 10;
	    int digit = (int)Math.log10(n);
	    return (int)(rem * Math.pow(10, digit)) + rev2(n/10);
    }
}
