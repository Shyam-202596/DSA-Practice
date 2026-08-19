public class CountZeros {

    static int count = 0;
	static int countZeros2(int n){
	   if(n == 0){
	       return count;
	   }
	   if(n % 10 == 0){
	       count += 1;
	       return countZeros2(n/10);
	   }
	   return countZeros2(n/10);
	}

    static int countZeros1(int n){
	   return helper(n, 0);
	}
	private static int helper(int n, int c){
	    if(n == 0){
	        return c;
	    }
	    if(n % 10 == 0){
	        return helper(n/10, c+1);
	    }
	    return helper(n/10, c);
    }
    public static void main(String[] args) {
        // count 0s.
		System.out.println(countZeros1(1908));
 
	}
}
