public class Power {
    public static void main(String[] args) {
        //write code to calculate the value of base 'a' to the power 'b'.
        int base = 3;
	    int power = 0;
	    int ans = 1;
	    while(power > 0){
	        if((power & 1) == 1){
	            ans *= base;
	        }
	        base *= base;
	        power = power >> 1;
	    }
	    System.out.println(ans);
    }
}
