public class SumOfNthRowInPascalTriangle {
    public static void main(String[] args) {
        int row = 5;
		int ans = numberOfDigit(row);
		System.out.println(ans);
	}
    //in pascal triangle find the sum of nth row.
	static int numberOfDigit(int row){
	   return 1 << row - 1;
    }
}
