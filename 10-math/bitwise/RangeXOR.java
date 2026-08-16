public class RangeXOR {
    public static void main(String[] args) {
        int n = 6;
        int ans = xor(n);
        System.out.println(ans);

        //write code to find XOR of numbers from 'a' to 'b'.
        int a = 4;
        int b = 12;
        int ans1 = xor(b) ^ xor(a - 1);
        System.out.println(ans1);
       // only for check, will give TLE for large numbers
        int ans2 = 0;
        for(int i = a; i <= b; i++){
            ans2 ^= i;
        }
        System.out.println(ans2);
    }
    // write code to find XOR of numbers from 0 to 'n'.
    static int xor(int n){
        if(n % 4 == 0){
            return n;
        }
        if(n % 4 == 1){
            return 1;
        }
        if(n % 4 == 2){
            return n + 1;
        }
        return 0;
    }
}
