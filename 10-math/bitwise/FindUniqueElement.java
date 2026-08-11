public class FindUniqueElement {
    public static void main (String[] args) {
		int[] arr = {2, 3, 4, 1, 2, 1, 3, 6, 4};
        int ans = findUniqueElement(arr);
        System.out.println(ans);
	}
	static int findUniqueElement(int[] arr){
	    int unique = 0;
	    for(int n : arr){
	        unique ^= n;
	    } 
	    return unique;
	}
}
