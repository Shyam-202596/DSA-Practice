public class Scope {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        String name = "Shyam";
        {
//            int a = 20; // it will give an error because we cannot declare a variable with the same name in the same scope.
            a = 20; // reassign the original ref variable to some other value.
            System.out.println(a);
            int c = 30; // valid in this block only, we can use this variable in this block only.
            System.out.println(c);
            name = "Rahul";
            System.out.println(name);
            // Remember: value initialized in this block will remain in block, we can't use this outside the block.
        }
        int c = 900;
        System.out.println(c);
        System.out.println(a);
        System.out.println(name);

        //scope in for loop
        for(int i=0; i<4; i++){
            System.out.println(i);
            int num = 90;
            a = 1000;
        }
        System.out.println(a);
         // System.out.println(i); // it will give an error because i is declared in the for loop and we cannot use it outside the for loop.
         // System.out.println(num); // it will give an error because num is declared in the for loop and we cannot use it outside the
    }
}
