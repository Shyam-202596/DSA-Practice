public class Stream {
    public static void main(String[] args) {
        String str = "baccad";
		String ans = remove(str);
		System.out.println(ans);
	}
	//brutforce : remove 'a' from given string.
	static String remove(String str){
	    String ans = "";
	    for(int i = 0; i < str.length(); i++){
	        if(str.charAt(i) != 'a'){
	            ans += str.charAt(i); 
	        }
	    }
	    return ans;
	}
    //brutforce : remove 'a' from given string using StringBuffer.
	static String remove1(String str){
	    StringBuffer sb = new StringBuffer(str);
	    for(int i = 0; i < sb.length(); i++){
	        if(sb.charAt(i) == 'a'){
	            sb.deleteCharAt(i); 
	        }
	    }
	    return sb.toString();
	}
    //remove 'a' from given string using Recursion
    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip(up.substring(1));
        }else{
            return ch + skip(up.substring(1));
        }
    }
    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        }else{
            skip(p + ch, up.substring(1));
        }
    }
    static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return ch + skipApple(up.substring(1));
        }
    }
    static String skipAppNotApple(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(up.startsWith("app")){
            return skipAppNotApple(up.substring(3));
        }else{
            return ch + skipAppNotApple(up.substring(1));
        }
    }
}
