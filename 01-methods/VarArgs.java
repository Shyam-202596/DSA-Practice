import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(1,2,3,4);
        demo(1,2);
        demo("Shyam","Mohan","Rakul");
        multiple(10, 20, "Shyam", "Mohan", "Radhey");
    }

    static void fun(int ...v){
        System.out.println(v.length);
        System.out.println(Arrays.toString(v));
    }

    static void demo(String ...v){
        System.out.println(Arrays.toString(v));
    }

    static void demo(int ...v){
        System.out.println(Arrays.toString(v));
    }

    static void multiple(int a, int b, String ...v){
        System.out.print(a + ", " + b+ ", ");
        System.out.println(Arrays.toString(v));
    }
}
