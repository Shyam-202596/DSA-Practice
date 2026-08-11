import java.util.Scanner;

public class StringExample {
    public static void main(String[] args) {
//        String message = myGreet("Shyam.");
//        System.out.println(message);
//
//        String msg = greet();
//        System.out.println(msg);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.next();
        String personalised = myGreet(name);
        System.out.println(personalised);
        String str = greet();
        System.out.println(str);
        sc.close();

    }

    static String myGreet(String name){
        String message = "Hello! " + name;
        return message;
    }

    static String greet(){
        String greeting  = "How are you?";
        return greeting;
    }


}
