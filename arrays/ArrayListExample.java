import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //syntax
        ArrayList<Integer> list = new ArrayList<>(5);
//        list.add(11);
//        list.add(42);
//        list.add(33);
//        list.add(21);
//        list.add(54);
//        list.add(65);
//        System.out.println(list);
//        System.out.println(list.contains(2));
//        System.out.println(list.contains(33));
//        System.out.println(list.size());
//        list.remove(2);
//        System.out.println(list);
//        list.set(0, 99);
//        System.out.println(list);

        //input
        for(int i = 0; i < 5; i++){
            list.add(sc.nextInt());
        }

        //getting values
        for(int i=0; i<5; i++){
            System.out.print(list.get(i) + " "); // pass index here, list[index] syntax will not work here
        }
        System.out.println();

        System.out.println(list);
    }
}
