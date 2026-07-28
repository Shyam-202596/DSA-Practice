public class SBuilder {
    public static void main(String[] arg){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            sb.append(ch);
        }

        System.out.println(sb);
        System.out.println(sb.toString());

        sb.reverse();
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder("abcba");
        System.out.println(sb1);
        StringBuilder sb2 = sb1.reverse();
        System.out.println(sb2);
    }
}
