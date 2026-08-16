public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 64;
	    boolean ans = isPowerOfTwo(n);
	    System.out.println(ans);
	}
    //write code to find out given number is power of 2 or not?
	static boolean isPowerOfTwo(int n){
	    return (n & n - 1) == 0;
    }
}
