package dsa.linear_search;

public class EvenDigits {
    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896, 1234, 0, -22, -3333};
        int result = evenDigitsNos(nums);
        System.out.println(result);
    }

    private static int evenDigitsNos(int[] arr) {
        int count = 0;
        for(int element:arr){
            if(even(element))
                count++;
        }
        return count;
    }

    private static boolean even(int element) {
        int numberOfDigits = countDigits(element);
        if(numberOfDigits % 2 == 0){
            return true;
        }
        return false;
    }

    private static int countDigits(int num){
        int count = 0;
        if(num==0) return 1;
        if(num<0) {
            num = num*-1;
        }
        while(num>0){
            count++;
            num = num /10;
        }
        return count;
    }
}
