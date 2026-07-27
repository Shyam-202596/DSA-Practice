import java.util.Arrays;

public class PassingInFunctions {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Before modification:");
        System.out.println(Arrays.toString(numbers));
        modifyArray(numbers);
        System.out.println("After modification:");
        System.out.println(Arrays.toString(numbers));
    }
    static void modifyArray(int[] numbers) {
        numbers[0] = 99;
    }
}
