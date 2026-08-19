public class Sum {
    public static void main(String[] args) {
        // find sum from 1 to n (till given number) using recursion.
		System.out.println(sum(10));
 
	}
	static int sum(int n){
	    if(n == 1){
	        return n;
	    }
	    return n + sum(n - 1);
    }
}
