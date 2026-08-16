public class HCF_LCM {
    public static void main(String[] args) {
        System.out.println(hcf(3, 5));
        System.out.println(lcm(3, 5));
    }
    //finding HCF (GCD)
    static int hcf(int a, int b){
        if(a == 0){
            return b;
        }
        return hcf(b%a, a); //Euclid Algorithm
    }
    //finding LCM
    static int lcm(int a, int b){
        return (a * b) / hcf(a, b);
    }
}
