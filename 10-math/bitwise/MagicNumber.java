public class MagicNumber {
    public static void main(String[] args) {
        int n = 6;
		int ans = findMagicNumber(n);
        System.out.println(ans);
    }

    //code for finding nth magic number.
    static int findMagicNumber(int n){
	    int magicNumber = 0;
	    int index = 1;
	    while(n > 0){
	        magicNumber += (n & 1) * Math.pow(5,index);
	        index++;
	        n = (n >> 1);
	    }
	    return magicNumber;
	}
}
