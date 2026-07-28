import java.util.ArrayList;

public class Operators {
    public static void main(String[] args){

        System.out.println('a' + 'b');
        System.out.println("a" + "b");
        System.out.println("a" + 'b');
        System.out.println('a'+ 1);
        System.out.println("a"+ 1); // this is same as after a few steps: "a" + "1"
        System.out.println((char)('a'+ 3));
        // integer will be converted to Integer that will call toString()
        System.out.println("Shyam" + new ArrayList<>());
        //System.out.println("Shyam" + new Integer(78));

        //String ans = new Integer(76) + "" + new ArrayList<>();
        String ans ="" + new ArrayList<>();
        System.out.println(ans);

    }
}
