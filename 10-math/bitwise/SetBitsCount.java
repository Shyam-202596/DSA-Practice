public class SetBitsCount {
    //write code for given a number n to count number of set bits (1's) in it.
    public static void main(String[] args) {
        //method 1.
	    int n = 31;
	    int count = 0;
	    while(n > 0){
	        if((n & 1) == 1){
	            count++;
	        }
	        n = n >> 1;
	    }
	    System.out.println(count);
        System.out.println(Integer.toBinaryString(n));
	    System.out.println(setBits(n));

	}
    //method 2
	static int setBits(int n){
	    int count = 0;
	    while(n > 0){
	        count++;
	        n = n & (n - 1);
	    }
	    return count;
    }
}
