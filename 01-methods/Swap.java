import java.sql.SQLOutput;

public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a + " "+ b); //it will give a = 10, b = 20.
        swap(a, b);
        System.out.println(a + " "+ b); //it will give a = 10, b = 20.

        String name = "Shyam sagar";
        changeName(name);
        System.out.println(name); //it will give name = "Shyam sagar".
    }

    static void swap(int num1, int num2){
        int temp = num1;
        num1 = num2;
        num2 = temp;
        //this change will only be valid in this function scope.
        System.out.println(num1 + " "+ num2); // it will give num1 = 20, num2 = 10.
    }

    static void changeName(String str){
        str = "Rahul Singh"; // creating a new object in the memory and assigning it to str.
        //this change will only be valid in this function scope.
        System.out.println(str); // it will give str = "Rahul Singh".
    }
}
