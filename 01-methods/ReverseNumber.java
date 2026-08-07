//https://leetcode.com/problems/reverse-integer/?envType=problem-list-v2&envId=egdfqalg

public class ReverseNumber {
    public static void main(String[] args){
		
		System.out.println(reverseNumber(-123));
	}
	
	static int reverseNumber(int n){
		int revNum = 0;

		while(n != 0){
			int digit = n % 10;
			n = n / 10;

			//Integer.MAX_VALUE = 2147483647
			//Integer.MIN_VALUE = -2147483648

			if(revNum > Integer.MAX_VALUE / 10 || (revNum == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }
            if(revNum < Integer.MIN_VALUE / 10 ||(revNum == Integer.MIN_VALUE / 10 && digit < -8)){
                return 0;
            }

			revNum = revNum * 10 + digit;
		}

		return revNum;
	}
}
