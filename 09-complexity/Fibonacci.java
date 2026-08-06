public class Fibonacci{
    public static void main(String[] args){
        for(int i = 0; i < 11; i++){
            System.out.println(fibo(i));
        }
    }

    static int fibo(int n){
        /*
        direct formula to find any Fibonacci number is: [((1+root(5))/2)^n - ((1-root(5))/2)^n]/root(5)
        **/
        return (int)((Math.pow(((1+Math.sqrt(5))/2), n) - Math.pow(((1-Math.sqrt(5))/2), n))/Math.sqrt(5));
    }
}