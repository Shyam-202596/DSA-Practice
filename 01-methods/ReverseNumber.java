public class ReverseNumber {
    public static void main(String[] args){
		
		System.out.println(reverseNumber(-123));
	}
	
	static int reverseNumber(int n){
		if(n == 0){
			return 0;
		}
		
		int revNum = 0;
		
		if(n < 0){
			n = n * (-1);
			while(n > 0){
			revNum = revNum * 10 + n % 10;
			n = n / 10;
			}
			return (-1)*revNum;
		}
		
		else{
			while(n > 0){
			revNum = revNum * 10 + n % 10;
			n = n / 10;
			}
		}
		return revNum;
	}
}
