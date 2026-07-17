package dsa.methods;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int n = sc.nextInt();
//        boolean ans = isPrime(n);
//        System.out.println(ans);

        // to print all 3-digits armstrong numbers (also known as narcissistic numbers).
        for(int i=100; i<1000; i++){
            if(isArmstrong(i)){
                System.out.println(i);
            }
        }

    }

    static boolean isArmstrong(int n){
        int sum = 0;
        int original = n;
        while(n > 0){
            int rem = n % 10;
            n = n/10;
            sum = sum + rem*rem*rem;
        }
        return sum == original;
    }

    static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        int c = 2;
        while(c * c <= n){
            if(n % c == 0){
                return false;
            }
            c++;
        }
        return c * c > n;
    }
}
