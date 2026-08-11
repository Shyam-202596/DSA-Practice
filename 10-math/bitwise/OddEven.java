public class OddEven {
    public static void main (String[] args)
	{
		int n = 12;
		System.out.println(checkOdd(n));
		System.out.println(checkEven(n));
 
	}
	static boolean checkOdd(int n){
	    return (n & 1) == 1;
	}
	static boolean checkEven(int n){
	    return (n & 1) == 0;
	}
}
