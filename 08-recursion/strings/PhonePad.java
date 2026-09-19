import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        //dialPad("", "12");
        System.out.println(DialPadRet("", "12"));
        System.out.println(DialPadCount("", "12"));
    }

    static void dialPad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';//to convert '1' to 1.
        for(int i = (digit - 1)*3; i < digit*3; i++){
            char ch = (char)('a' + i);
            dialPad(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> DialPadRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';//to convert '1' to 1.
        ArrayList<String> ans = new ArrayList<>();
        for(int i = (digit - 1)*3; i < digit*3; i++){
            char ch = (char)('a' + i);
            ans.addAll(DialPadRet(p + ch, up.substring(1)));
        }
        return ans;
    }

    static int DialPadCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int digit = up.charAt(0) - '0';//to convert '1' to 1.
        int count = 0;
        for(int i = (digit - 1)*3; i < digit*3; i++){
            char ch = (char)('a' + i);
            count = count + DialPadCount(p + ch, up.substring(1));
        }
        return count;
    }
}
