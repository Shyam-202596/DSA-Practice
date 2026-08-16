public class NewtonSQRT {
    public static void main(String[] args) {
        double n = 40;
        double ans = newtonSQRT(n);
        System.out.println(ans);
    }

    static double newtonSQRT(double n) {
        double x = n;
        double root;

        while (true) {
            
            root = 0.5 * (x + (n / x));

            if(Math.abs(root - x) < 0.5){
                break;
            }
            x = root;
        }
        return root;
    }
}
