public class Shadowing {
    static int x = 10;
    public static void main(String[] args) {
        System.out.println(x);//10
        int x; // the class variable at line number 4 is shadowed by this local variable.
        // System.out.println(x); // compile time error because local variable x is not initialized. scope will begin when value is initialized.
        x = 20; // now local variable x is initialized and we can use it.
        System.out.println(x); //20
         // to access the class variable x we can use the class name.
        System.out.println(Shadowing.x); //10
        fun();
    }
    static void fun(){
        System.out.println(x); //10 because there is no local variable x in this function, so it will access the class variable x.
    }
}
