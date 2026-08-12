//Code for reset the targeted bit ( if target bit is 1 then covert it to 0 and vice versa)
public class BitReset {
    public static void main(String[] args) {
        int n = 63;
        System.out.println(Integer.toBinaryString(n));
        int target = 4;
        int ans = reset(n, target);
        System.out.println(Integer.toBinaryString(ans));
    }
    static int reset(int n, int i){
        return (n & (~(1 << i - 1)));
    }
}
