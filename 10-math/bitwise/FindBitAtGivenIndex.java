public class FindBitAtGivenIndex {
    public static void main (String[] args){
	    int n = 27;
	    int targetIndex = 4;
	    int ans = findBit(n, targetIndex);
	    System.out.println(ans);
	}
	static int findBit(int n, int i){
	    //return (n & (1 << i - 1)) != 0 ? 1 : 0;
	    return (n >> (i - 1)) & 1;
	}
}
