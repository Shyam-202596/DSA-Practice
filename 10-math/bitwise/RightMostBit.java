public class RightMostBit {
    public static void main(String[] args) {
          int n = 60;
        System.out.println(Integer.toBinaryString(n));
 
        int ans = rightMostBit1(n);
        System.out.println(ans);
    }
    //method 1: not optimal solution.
    static int rightMostBit1(int n) {
        int count = 0;
 
        while (n > 0) {
 
            if ((n & 1) == 1) {
                return (1 << count);
            }
 
            count++;
            n = n >> 1;
        }
        return 0;
    }
    //method2: most optimal solution.
    static int rightMostBit2(int n){
        return n & -n;
    }
}
