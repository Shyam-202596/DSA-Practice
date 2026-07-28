import java.util.Arrays;
public class Methods {
    public static void main(String[] args){

        String name = "Shyam Sagar Hello World";

        System.out.println(Arrays.toString(name.toCharArray()));
        System.out.println(name.toLowerCase());
        System.out.println(name);
        System.out.println(name.indexOf('y'));
        System.out.println("   Shyam    ".strip());
        System.out.println(Arrays.toString(name.split(" ")));

    }
}
