public class Comparison{
    public static void main(String[] args){

        String a = "Shyam";
        String b = "Shyam";
        String c = a;

        System.out.println(a == b);
        System.out.println(c == b);

        String name1 = new String("Shyam");
        String name2 = new String("Shyam");

        System.out.println(name1 == name2); // == operator compares references, it will return false
        System.out.println(name1.equals(name2)); // .equals method compares values or contents. It will return true.
    }
}