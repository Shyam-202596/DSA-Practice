import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        sum();

        int ans = sum2();
        System.out.println("The sum is: "+ ans);

        int res = sum3(13, 23);
        System.out.println("The sum is: "+ res);

    }
    static void sum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter number2: ");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.println("The sum is: "+ sum);
    }

    //return the value.
    static int sum2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter number2: ");
        int num2 = sc.nextInt();
        return num1 + num2;
        //System.out.println("This will never execute");
    }

    //pass the value of numbers when you are calling the method in main().
    static int sum3(int a, int b){
        return a + b;
    }
}
