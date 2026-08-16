public class BinarySearchSQRT {
    public static void main(String[] args) {
        int n = 30;
        int p = 3;
        double ans = binarySQRT(n, p);
        System.out.printf("%.3f", ans);
    }
    //finding square root of a given number.
    static double binarySQRT(int n, int p) {
        int s = 0;
        int e = n;
        double sqrt = 0;
        while (s < e) {
 
            int m = s + (e - s) / 2;
 
            if (m * m == n) {
                return m;
            }
 
            if (m * m > n) {
                e = m - 1;
            } else {
                s = m + 1;
                sqrt = m;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (sqrt * sqrt <= n) {
                sqrt += incr;
            }
            sqrt -= incr;
            incr /= 10;
        }
        return sqrt;
    }
}
