public class Nto1{
    public static void main(String[] args) {
        print(5);
    }
    static void print(int n){
	    if(n == 1){
	        System.out.println(n);
	        return;
	    }
	    System.out.println(n); // It will print 5 to 1.
	    print(n-1);
	    System.out.println(n); // it will print 1 to 5.
	}
}
