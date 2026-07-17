package dsa.methods;

public class Overloading {
    public static void main(String[] args) {
        fun(11);
        fun("Shyam");
        int ans = sum(12,23);
        System.out.println("The sum of two numbers is: "+ ans);
        int res = sum(1,23,45);
        System.out.println("The sum three numbers is: "+ res);
    }

    static int sum(int a, int b){
        return a + b;
    }

    static int sum(int a, int b, int c){
        return a + b + c;
    }

    static void fun(int a){
        System.out.print("First method: ");
        System.out.println(a);
    }

    static void fun(String s){
        System.out.print("Second method: ");
        System.out.println(s);
    }
}

