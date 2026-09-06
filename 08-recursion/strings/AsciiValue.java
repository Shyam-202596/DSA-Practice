public class AsciiValue {
    public static void main(String[] args) {
        char ch = 'a';
        System.out.println(ch + 0);
        System.out.println((int)ch);
        System.out.println(ch);
        System.out.println(ch + 1);
        System.out.println((char)(ch + 1));

        printAllAlphabets();
    }
    static void printAllAlphabets(){
        //char ch = 'A';
        char ch = 'a';
        for(int i = 0; i < 26; i++){
            System.out.print((char)(ch + i) + " ");
        }
    }
}
